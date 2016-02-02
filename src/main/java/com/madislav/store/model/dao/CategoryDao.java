package com.madislav.store.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.madislav.store.model.Category;

@Repository
public class CategoryDao {

	@PersistenceContext
    private EntityManager entityManager;
     
	public long countCategories() {
        return entityManager.createQuery("SELECT COUNT(o) FROM Category o", Long.class).getSingleResult();
    }

	public List<Category> findAllCategories() {
        return entityManager.createQuery("SELECT o FROM Category o", Category.class).getResultList();
    }

	public Category findCategory(Long id) {
        if (id == null) return null;
        return entityManager.find(Category.class, id);
    }
	
	public Category findCategoryEagerly(Long id) {
		if (id == null) return null;
        return entityManager.createQuery("SELECT o FROM Category o LEFT OUTER JOIN FETCH o.products WHERE o.id = (:id)", Category.class)
            	.setParameter("id", id).getSingleResult();
	}

	public List<Category> findCategoryEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM Category o", Category.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	
    public void persist(Category category) {
		entityManager.persist(category);
    }

	
    public void remove(Category category) {
        if (this.entityManager.contains(category)) {
            this.entityManager.remove(category);
        } else {
            category = findCategory(category.getId());
            this.entityManager.remove(category);
        }
    }

	
    public void flush() {
        entityManager.flush();
    }

	
    public void clear() {
        entityManager.clear();
    }


    public Category merge(Category category) {
        Category merged = entityManager.merge(category);
        entityManager.flush();
        return merged;
    }

}
