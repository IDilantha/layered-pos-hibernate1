package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.custom.QueryDAO;
import lk.ijse.dep.pos.entity.CustomEntity;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    private Session session;
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public CustomEntity getOrderInfo(int orderId) throws Exception {
        return (CustomEntity) session.createQuery("SELECT NEW lk.ijse.dep.pos.entity.CustomEntity(o.id, c.id,c.name,o.date) FROM Customer c INNER JOIN c.orders o WHERE o.id=?1")
                .setParameter(1, orderId)
                .uniqueResult();
    }

    @Override
    public CustomEntity getOrderInfo2(int orderId) throws Exception {
//        ResultSet rst = CrudUtil.execute("SELECT O.id, C.customerId, C.name, O.date, SUM(OD.qty * OD.unitPrice) AS Total  FROM Customer C INNER JOIN `Order` O ON C.customerId=O.customerId\" +\n" +
//                "                \" INNER JOIN OrderDetail OD on O.id = OD.orderId WHERE O.id=? GROUP BY orderId", orderId);
//        if (rst.next()){
//            return new CustomEntity(rst.getInt(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getDate(4),
//                    rst.getDouble(5));
//        }else{
//            return null;
//        }
        return null;
    }

    @Override
    public List<CustomEntity> getOrdersInfo(String query) throws Exception {
//        ResultSet rst = CrudUtil.execute("SELECT O.id, C.customerId, C.name, O.date, SUM(OD.qty * OD.unitPrice) AS Total  FROM Customer C INNER JOIN `Order` O ON C.customerId=O.customerId " +
//                "INNER JOIN OrderDetail OD on O.id = OD.orderId WHERE O.id LIKE ? OR C.customerId LIKE ? OR C.name LIKE ? OR O.date LIKE ? GROUP BY O.id", query,query,query,query);
//        List<CustomEntity> al = new ArrayList<>();
//        while (rst.next()){
//            al.add(new CustomEntity(rst.getInt(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getDate(4),
//                    rst.getDouble(5)));
//        }
//        return al;
        return null;
    }
}
