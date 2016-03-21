package com.madislav.store.model.dao;

import com.madislav.store.model.Purchase;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SuppressWarnings("unchecked")
@Repository
public class PurchaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void persist(Purchase purchase) {
        sessionFactory.getCurrentSession().persist(purchase);
    }

    public long countPurchases() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(o) FROM Purchase o").uniqueResult();
    }

    public List<Purchase> findAllPurchases() {
        return (List<Purchase>) sessionFactory.getCurrentSession()
                .createQuery("SELECT o FROM Purchase o").uniqueResult();
    }

    public Purchase findPurchase(Long id) {
        if (id == null) return null;
        return (Purchase) sessionFactory.getCurrentSession().get(Purchase.class, id);
    }

    public List<Purchase> findPurchaseEntries(int firstResult, int maxResults) {
        return (List<Purchase>) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Purchase o")
                .setFirstResult(firstResult).setMaxResults(maxResults).uniqueResult();
    }


    public void remove(Purchase purchase) {
        if (sessionFactory.getCurrentSession().contains(purchase)) {
            sessionFactory.getCurrentSession().delete(purchase);
        } else {
            Purchase attached = findPurchase(purchase.getId());
            sessionFactory.getCurrentSession().delete(attached);
        }
    }


    public void flush() {
        sessionFactory.getCurrentSession().flush();
    }


    public void clear() {
        sessionFactory.getCurrentSession().clear();
    }


    public Purchase merge(Purchase purchase) {
        Purchase merged = (Purchase) sessionFactory.getCurrentSession().merge(purchase);
        sessionFactory.getCurrentSession().flush();
        return merged;
    }


}
