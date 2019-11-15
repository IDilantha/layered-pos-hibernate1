package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.OrderDetailDAO;
import lk.ijse.dep.pos.entity.OrderDetail;
import lk.ijse.dep.pos.entity.OrderDetailPK;
import org.hibernate.Session;

import java.util.List;

public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail,OrderDetailPK> implements OrderDetailDAO {

    @Override
    public List<OrderDetail> findAll() throws Exception {
       return session.createNativeQuery("FROM OrderDetail").list();
    }

    @Override
    public OrderDetail find(OrderDetailPK orderDetailPK) throws Exception {
        return session.find(OrderDetail.class,orderDetailPK);
    }


    @Override
    public boolean existsByItemCode(String itemCode) throws Exception {
        return (boolean) session.createNativeQuery("SELECT * FROM OrderDetail WHERE itemCode=?1").setParameter(1,itemCode).uniqueResult();
    }
}
