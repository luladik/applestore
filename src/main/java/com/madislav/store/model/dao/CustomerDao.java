package com.madislav.store.model.dao;

import com.madislav.store.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SuppressWarnings("unchecked")
@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void persist(Customer customer) {
        sessionFactory.getCurrentSession().persist(customer);
    }

    public long countCustomers() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(o) FROM Customer o").uniqueResult();
    }


    public List<Customer> findAllCustomers() {
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Customer o").list();
    }

    public Customer findCustomerById(Long id) {
        if (id == null) return null;
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    public List<Customer> findCustomerEntries(int firstResult, int maxResults) {
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Customer o")
                .setFirstResult(firstResult).setMaxResults(maxResults).list();
    }


    public void remove(Customer customer) {
        if (this.sessionFactory.getCurrentSession().contains(customer)) {
            this.sessionFactory.getCurrentSession().delete(customer);
        } else {
            Customer attached = findCustomerById(customer.getId());
            this.sessionFactory.getCurrentSession().delete(attached);
        }
    }


    public void flush() {
        this.sessionFactory.getCurrentSession().flush();
    }


    public void clear() {
        this.sessionFactory.getCurrentSession().clear();
    }


    public Customer merge(Customer customer) {
        Customer merged = (Customer) sessionFactory.getCurrentSession().merge(customer);
        this.sessionFactory.getCurrentSession().flush();
        return merged;
    }

    public Customer findCustomerByUsername(String name) {
        List<Customer> customers;
        customers = sessionFactory.getCurrentSession()
                .createQuery("from Customer where name = ?")
                .setParameter(0, name).list();

        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;

        }


    }
}

