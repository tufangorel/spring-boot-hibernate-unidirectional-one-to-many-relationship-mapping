package com.company.customerinfo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime orderDate;

    @JoinColumn(name = "fk_customer_id")
    @OneToOne
    private Customer customer;

    private String title;

    @JoinColumn(name = "fk_customer_order_id")
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", title='" + title + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
