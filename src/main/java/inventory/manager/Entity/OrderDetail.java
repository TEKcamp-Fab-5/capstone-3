package inventory.manager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    // removed the orderDetails_id because it is unnecessary
    // no idea if this works

    @ManyToOne
    @JoinColumn(name = "product_serial")
    private Product product;

    @OneToMany
    @JoinColumn(name = "transaction_serial")
    private Order order;

    @OneToMany
    @JoinColumn(name = "account_serial")
    private Account account;


}
