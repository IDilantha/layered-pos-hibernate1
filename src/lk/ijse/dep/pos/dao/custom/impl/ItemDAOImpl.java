package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.ItemDAO;
import lk.ijse.dep.pos.entity.Item;
import org.hibernate.Session;

import java.util.List;

public class ItemDAOImpl extends CrudDAOImpl<Item,String> implements ItemDAO {

    @Override
    public String getLastItemCode() throws Exception {
        return (String) session.createNativeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1").uniqueResult();
    }

    @Override
    public boolean existsByItemId(String itemId) throws Exception {
        return (boolean) session.createNativeQuery("SELECT * FROM Item WHERE code=?1").setParameter(1,itemId).uniqueResult();
    }

}
