package com.madislav.store.model.dao;

import com.madislav.store.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDao {

	@PersistenceContext
    private EntityManager entityManager;
     
	public long countCustomers() {
        return entityManager.createQuery("SELECT COUNT(o) FROM Customer o", Long.class).getSingleResult();
    }

	public List<Customer> findAllCustomers() {
        return entityManager.createQuery("SELECT o FROM Customer o", Customer.class).getResultList();
    }

	public Customer findCustomer(Long id) {
        if (id == null) return null;
        return entityManager.find(Customer.class, id);
    }

	public List<Customer> findCustomerEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM Customer o", Customer.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist(Customer customer) {
        this.entityManager.persist(customer);
    }

	@Transactional
    public void remove(Customer customer) {
        if (this.entityManager.contains(customer)) {
            this.entityManager.remove(customer);
        } else {
            Customer attached = findCustomer(customer.getId());
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        this.entityManager.clear();
    }

	@Transactional
    public Customer merge(Customer customer) {
        Customer merged = entityManager.merge(customer);
        this.entityManager.flush();
        return merged;
    }

	public TypedQuery<Customer> findCustomersByNameEquals(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        //:name
        TypedQuery<Customer> q = entityManager.createQuery("SELECT o FROM Customer AS o WHERE o.name = :name", Customer.class);
        q.setParameter("name", name);
        return q;
    }


}

