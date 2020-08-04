//package inventory.manager.Entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "order_details")
//public class OrderDetail {
//
//    // removed the orderDetails_id because it is unnecessary
//    // no idea if this works
//
//    @ManyToOne
//    @JoinColumn(name = "product_serial")
//    @Column(nullable = false)
//    private Product product;
//
//    @OneToMany
//    @JoinColumn(name = "transaction_serial")
//    @Column(nullable = false)
//    private Order order;
//
//    @OneToMany
//    @JoinColumn(name = "account_serial")
//    @Column(nullable = false)
//    private Account account;
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public OrderDetail(Product product, Order order, Account account) {
//        this.product = product;
//        this.order = order;
//        this.account = account;
//    }
//
//    public OrderDetail() {
//    }
//}
