package com.madislav.store.model.dao;

import com.madislav.store.model.Product;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SuppressWarnings("unchecked")
@Repository
public class ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> findProductsByFeatured(Boolean featured) {

        List<Product> products;

        products = sessionFactory.getCurrentSession()
                .createQuery("FROM Product WHERE featured = ?")
                .setParameter(0, featured).list();
        return products;
    }

    public long countProducts() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(o) FROM Product o").uniqueResult();
    }

    public List<Product> findAllProducts() {
        return (List<Product>) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Product o").uniqueResult();
    }

    public Product findProduct(Long id) {
        if (id == null) return null;
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public List<Product> findProductEntries(int firstResult, int maxResults) {
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Product o")
                .setFirstResult(firstResult).setMaxResults(maxResults).list();
    }

    public List<Product> findProductEntries(Product product) {
        Query query = null;
        if (product.getCategory() != null && product.getCategory().getId() != 0) {
            query = (Query) sessionFactory.getCurrentSession()
                    .createQuery("SELECT o FROM Product o WHERE o.name like :name and o.category = :category");
            query.setParameter("name", "%" + product.getName() + "%");
            query.setParameter("category", product.getCategory());
        } else {
            query = (Query) sessionFactory.getCurrentSession()
                    .createQuery("SELECT o FROM Product o WHERE o.name like :name");
            query.setParameter("name", "%" + product.getName() + "%");
        }
        return (List<Product>) query.uniqueResult();
    }


    public void persist(Product product) {
        this.sessionFactory.getCurrentSession().persist(product);
    }

    public void remove(Product product) {
        if (this.sessionFactory.getCurrentSession().contains(product)) {
            this.sessionFactory.getCurrentSession().delete(product);
        } else {
            Product attached = findProduct(product.getId());
            this.sessionFactory.getCurrentSession().delete(attached);
        }
    }

    public void flush() {
        this.sessionFactory.getCurrentSession().flush();
    }

    public void clear() {
        this.sessionFactory.getCurrentSession().clear();
    }

    public Product merge(Product product) {
        Product merged = (Product) this.sessionFactory.getCurrentSession().merge(product);
        this.sessionFactory.getCurrentSession().flush();
        return merged;
    }


}
