package lk.ijse.dep.pos.dao.custom.impl;


import lk.ijse.dep.pos.db.DBConnection;
import lk.ijse.dep.pos.entity.Gender;

import java.sql.Connection;
import java.sql.PreparedStatement;

class CustomerDAOImplTest {

    static class Test{
        Gender g;

        Test(Gender g){
            this.g = g;
        }


    }

    public static void main(String[] args) throws Exception {
        Test test = new Test(Gender.FEMALE);
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO Customer VALUES ('C018','Kasun','Galle',?)");
        stm.setString(1, String.valueOf(test.g));
        System.out.println(stm);
        int i = stm.executeUpdate();
        System.out.println(test.g);
//        new CustomerDAOImplTest().findAll();
//        new CustomerDAOImplTest().save();
//        new CustomerDAOImplTest().findAll();
    }


    void findAll() throws Exception {
//        new CustomerDAOImpl().findAll().forEach(System.out::println);
    }

    void save() throws Exception {
//        new CustomerDAOImpl().save(new Customer("C014","Kusmadevi","Heaven", Gender.FEMALE));
    }
}
