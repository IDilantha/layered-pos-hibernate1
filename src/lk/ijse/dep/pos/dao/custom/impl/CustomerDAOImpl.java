package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.pos.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String getLastCustomerId() throws Exception {
        return (String) session.createNativeQuery("SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1").uniqueResult();
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return (boolean) session.createNativeQuery("SELECT * FROM Customer WHERE customerId=?1").setParameter(1,customerId).uniqueResult();
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return session.createQuery("FROM Customer",Customer.class).list();
    }

    @Override
    public Customer find(String s) throws Exception {
        return session.find(Customer.class,s);
    }

    @Override
    public void save(Customer entity) throws Exception {
       session.save(entity);
    }

    @Override
    public void update(Customer customer) throws Exception {
        session.merge(customer);
    }

    @Override
    public void delete(String s) throws Exception {
        session.delete(session.load(Customer.class,s));
    }


}
