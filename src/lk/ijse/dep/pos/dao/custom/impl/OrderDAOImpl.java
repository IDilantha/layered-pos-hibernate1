package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.OrderDAO;
import lk.ijse.dep.pos.entity.Order;
import org.hibernate.Session;

import java.util.List;

public class OrderDAOImpl extends CrudDAOImpl<Order,Integer> implements OrderDAO {

    @Override
    public int getLastOrderId() throws Exception {
        return (int) session.createNativeQuery("SELECT id FROM `Order` ORDER BY id DESC LIMIT 1").uniqueResult();
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return (boolean) session.createNativeQuery("SELECT * FROM `Order` WHERE customerId=?1").setParameter(1,customerId).uniqueResult();
    }
}
