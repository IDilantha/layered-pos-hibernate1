package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.pos.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerDAOImpl extends CrudDAOImpl<Customer,String> implements CustomerDAO {

    @Override
    public String getLastCustomerId() throws Exception {
        return (String) session.createNativeQuery("SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1").uniqueResult();
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return (boolean) session.createNativeQuery("SELECT * FROM Customer WHERE customerId=?1").setParameter(1,customerId).uniqueResult();
    }



}
