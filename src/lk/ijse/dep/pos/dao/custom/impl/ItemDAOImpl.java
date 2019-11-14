package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudUtil;
import lk.ijse.dep.pos.dao.custom.ItemDAO;
import lk.ijse.dep.pos.entity.Item;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    private Session session;

    @Override
    public String getLastItemCode() throws Exception {
        return (String) session.createNativeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1").uniqueResult();
    }

    @Override
    public List<Item> findAll() throws Exception {
        return session.createQuery("FROM Item",Item.class).list();
    }

    @Override
    public Item find(String itemCode) throws Exception {
       return session.find(Item.class,itemCode);
    }

    @Override
    public void save(Item item) throws Exception {
        session.save(item);
    }

    @Override
    public void update(Item item) throws Exception {
        session.merge(item);
    }

    @Override
    public void delete(String itemCode) throws Exception {
        session.delete(session.load(Item.class,itemCode));
    }
}
