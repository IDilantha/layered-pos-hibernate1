package lk.ijse.dep.pos.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order implements SuperEntity{
    @Id
    private int id;
    private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    List<OrderDetail> orderDetails = new ArrayList<>();

    public Order() {
    }

    public Order(int id, Date date, String customerId) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);
    }




    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
