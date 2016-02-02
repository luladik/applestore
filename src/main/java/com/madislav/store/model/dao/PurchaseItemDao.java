package com.madislav.store.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.madislav.store.model.Product;
import com.madislav.store.model.Purchase;
import com.madislav.store.model.PurchaseItem;

@Repository
public class PurchaseItemDao {

	@PersistenceContext
    private EntityManager entityManager;

	public long countPurchaseItems() {
        return entityManager.createQuery("SELECT COUNT(o) FROM PurchaseItem o", Long.class).getSingleResult();
    }

	public List<PurchaseItem> findAllPurchaseItems() {
        return entityManager.createQuery("SELECT o FROM PurchaseItem o", PurchaseItem.class).getResultList();
    }

	public PurchaseItem findPurchaseItem(Long id) {
        if (id == null) return null;
        return entityManager.find(PurchaseItem.class, id);
    }

	public List<PurchaseItem> findPurchaseItemEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM PurchaseItem o", PurchaseItem.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist(PurchaseItem purchaseItem) {
        entityManager.persist(purchaseItem);
    }

	@Transactional
    public void remove(PurchaseItem purchaseItem) {
        if (entityManager.contains(purchaseItem)) {
            entityManager.remove(purchaseItem);
        } else {
            PurchaseItem attached = findPurchaseItem(purchaseItem.getId());
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
    public PurchaseItem merge(PurchaseItem purchaseItem) {
        PurchaseItem merged = entityManager.merge(purchaseItem);
        entityManager.flush();
        return merged;
    }


}
