package com.madislav.store.model.service;

import com.madislav.store.model.Customer;
import com.madislav.store.model.Product;
import com.madislav.store.model.Purchase;
import com.madislav.store.model.PurchaseItem;
import com.madislav.store.model.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Service
@Transactional
public class PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    public long countAllPurchases() {
        return purchaseDao.countPurchases();
    }

    public void deletePurchase(Purchase purchase) {
        purchaseDao.remove(purchase);
    }

    public Purchase findPurchase(Long id) {
        return purchaseDao.findPurchase(id);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseDao.findAllPurchases();
    }

    public List<Purchase> findPurchaseEntries(int firstResult, int maxResults) {
        return purchaseDao.findPurchaseEntries(firstResult, maxResults);
    }

    public void savePurchase(Purchase purchase) {
        purchaseDao.persist(purchase);
    }

    public Purchase updatePurchase(Purchase purchase) {
        return purchaseDao.merge(purchase);
    }

    public void savePurchase(Map<Product, Integer> cartContents, Customer purchasedBy) {

        Purchase purchase = new Purchase();
        Calendar now = Calendar.getInstance();
        for (Entry<Product, Integer> entry : cartContents.entrySet()) {
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setProduct(entry.getKey());
            purchaseItem.setQuantity(entry.getValue());
            purchaseItem.setOrderDate(now);

            purchaseItem.setPurchase(purchase);
            purchase.getPurchaseItems().add(purchaseItem);
        }
        purchase.setOrderDate(now);
        purchase.setOrderedBy(purchasedBy);

        this.savePurchase(purchase);
    }
}
