package lk.ijse.dep.pos.db;

import lk.ijse.dep.crypto.DEPCrypt;
import lk.ijse.dep.pos.entity.Customer;
import lk.ijse.dep.pos.entity.Item;
import lk.ijse.dep.pos.entity.Order;
import lk.ijse.dep.pos.entity.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        File file = new File("resources/application.properties");
        Properties properties = new Properties();

        try(FileInputStream fis = new FileInputStream(file)){
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .loadProperties(file)
                .applySetting("hibernate.connection.username", DEPCrypt.decode(properties.getProperty("hibernate.connection.username"),"dep4"))
                .applySetting("hibernate.connection.password", DEPCrypt.decode(properties.getProperty("hibernate.connection.password"),"dep4"))
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}