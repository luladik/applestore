package com.madislav.store.model.dao;

import com.madislav.store.model.Purchase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PurchaseDao {

	@PersistenceContext
    private EntityManager entityManager;
     

	public long countPurchases() {
        return entityManager.createQuery("SELECT COUNT(o) FROM Purchase o", Long.class).getSingleResult();
    }

	public List<Purchase> findAllPurchases() {
        return entityManager.createQuery("SELECT o FROM Purchase o", Purchase.class).getResultList();
    }

	public Purchase findPurchase(Long id) {
        if (id == null) return null;
        return entityManager.find(Purchase.class, id);
    }

	public List<Purchase> findPurchaseEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM Purchase o", Purchase.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist(Purchase purchase) {
        entityManager.persist(purchase);
    }

	@Transactional
    public void remove(Purchase purchase) {
        if (entityManager.contains(purchase)) {
            entityManager.remove(purchase);
        } else {
            Purchase attached = findPurchase(purchase.getId());
            entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        entityManager.flush();
    }

	@Transactional
    public void clear() {
        entityManager.clear();
    }

	@Transactional
    public Purchase merge(Purchase purchase) {
        Purchase merged = entityManager.merge(purchase);
        entityManager.flush();
        return merged;
    }


}
