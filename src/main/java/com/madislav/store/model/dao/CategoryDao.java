package com.madislav.store.model.dao;

import com.madislav.store.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void persist(Category category) {
        sessionFactory.getCurrentSession().persist(category);
    }

    public long countCategories() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(o) FROM Category o").uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAllCategories() {
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Category o").list();
    }

    public Category findCategory(Long id) {
        if (id == null) return null;
        return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
    }

    public Category findCategoryEagerly(Long id) {
        if (id == null) return null;
        return (Category) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Category o LEFT OUTER JOIN FETCH o.products WHERE o.id = (:id)")
                .setParameter("id", id).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Category> findCategoryEntries(int firstResult, int maxResults) {
        return (List<Category>) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Category o")
                .setFirstResult(firstResult).setMaxResults(maxResults).uniqueResult();
    }


    public void remove(Category category) {
        if (this.sessionFactory.getCurrentSession().contains(category)) {
            this.sessionFactory.getCurrentSession().delete(category);
        } else {
            category = findCategory(category.getId());
            this.sessionFactory.getCurrentSession().delete(category);
        }
    }

    public void flush() {
        sessionFactory.getCurrentSession().flush();
    }


    public void clear() {
        sessionFactory.getCurrentSession().clear();
    }


    public Category merge(Category category) {
        Category merged = (Category) sessionFactory.getCurrentSession().merge(category);
        sessionFactory.getCurrentSession().flush();
        return merged;
    }

}
