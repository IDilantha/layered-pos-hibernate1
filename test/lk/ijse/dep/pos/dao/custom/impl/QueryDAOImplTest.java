package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.entity.CustomEntity;

import java.sql.Date;
import java.util.List;

class QueryDAOImplTest {

    public static void main(String[] args) throws Exception {
        new QueryDAOImplTest().getOrderInfo();
    }

    void getOrderInfo2() throws Exception {
        CustomEntity e = new QueryDAOImpl().getOrderInfo2(2);
        assert e.getCustomerName().equals("Wimal1") &&
                e.getOrderDate().equals(Date.valueOf("2019-05-28")): "Invalid getOrderInfo2";
    }

    void getOrderInfo() throws Exception {
        List<CustomEntity> ordersInfo = new QueryDAOImpl().getOrdersInfo("T%");
        for (CustomEntity customEntity : ordersInfo) {
            System.out.println(customEntity.getOrderId());
            System.out.println(customEntity.getCustomerName());
            System.out.println(customEntity.getOrderTotal());
        }
    }
}
