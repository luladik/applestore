package com.madislav.store.model.dao;

import com.madislav.store.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDao {

	@PersistenceContext
    private EntityManager entityManager;
     
	public List<Product> findProductsByFeatured(Boolean featured) {
        if (featured == null) throw new IllegalArgumentException("The featured argument is required");
        TypedQuery<Product> q = entityManager.createQuery("SELECT o FROM Product AS o WHERE o.featured = :featured", Product.class);
        q.setParameter("featured", featured);
        return q.getResultList();
    }

	public long countProducts() {
        return entityManager.createQuery("SELECT COUNT(o) FROM Product o", Long.class).getSingleResult();
    }

	public List<Product> findAllProducts() {
        return entityManager.createQuery("SELECT o FROM Product o", Product.class).getResultList();
    }

	public Product findProduct(Long id) {
        if (id == null) return null;
        return entityManager.find(Product.class, id);
    }

	public List<Product> findProductEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM Product o", Product.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
	
	@SuppressWarnings("unchecked")
	public List<Product> findProductEntries(Product product) {
		Query query = null;
		if (product.getCategory() != null && product.getCategory().getId() != 0) {
			query = entityManager.createQuery("SELECT o FROM Product o WHERE o.name like :name and o.category = :category", Product.class);
			query.setParameter("name", "%" + product.getName() + "%");
	        query.setParameter("category", product.getCategory());
		}
		else {
			query = entityManager.createQuery("SELECT o FROM Product o WHERE o.name like :name", Product.class);
	        query.setParameter("name", "%" + product.getName() + "%");
		}
        return query.getResultList();
    }

	
	public void persist(Product product) {
        this.entityManager.persist(product);
    }

	public void remove(Product product) {
        if (this.entityManager.contains(product)) {
            this.entityManager.remove(product);
        } else {
            Product attached = findProduct(product.getId());
            this.entityManager.remove(attached);
        }
    }

	public void flush() {
        this.entityManager.flush();
    }

	public void clear() {
        this.entityManager.clear();
    }

	public Product merge(Product product) {
        Product merged = this.entityManager.merge(product);
        this.entityManager.flush();
        return merged;
    }



}
