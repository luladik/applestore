package com.madislav.store.model.dao;

import com.madislav.store.model.PurchaseItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SuppressWarnings("unchecked")
@Repository
public class PurchaseItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public long countPurchaseItems() {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(o) FROM PurchaseItem o").uniqueResult();
    }

    public List<PurchaseItem> findAllPurchaseItems() {
        return (List<PurchaseItem>) sessionFactory.getCurrentSession().
                createQuery("SELECT o FROM PurchaseItem o").uniqueResult();
    }

    public PurchaseItem findPurchaseItem(Long id) {
        if (id == null) return null;
        return (PurchaseItem) sessionFactory.getCurrentSession().get(PurchaseItem.class, id);
    }

    public List<PurchaseItem> findPurchaseItemEntries(int firstResult, int maxResults) {
        return (List<PurchaseItem>) sessionFactory.getCurrentSession()
                .createQuery("SELECT o FROM PurchaseItem o")
                .setFirstResult(firstResult).setMaxResults(maxResults).uniqueResult();
    }


    public void persist(PurchaseItem purchaseItem) {
        sessionFactory.getCurrentSession().persist(purchaseItem);
    }


    public void remove(PurchaseItem purchaseItem) {
        if (sessionFactory.getCurrentSession().contains(purchaseItem)) {
            sessionFactory.getCurrentSession().delete(purchaseItem);
        } else {
            PurchaseItem attached = findPurchaseItem(purchaseItem.getId());
            sessionFactory.getCurrentSession().delete(attached);
        }
    }


    public void flush() {
        sessionFactory.getCurrentSession().flush();
    }


    public void clear() {
        sessionFactory.getCurrentSession().clear();
    }


    public PurchaseItem merge(PurchaseItem purchaseItem) {
        PurchaseItem merged = (PurchaseItem) sessionFactory.getCurrentSession().merge(purchaseItem);
        sessionFactory.getCurrentSession().flush();
        return merged;
    }


}
