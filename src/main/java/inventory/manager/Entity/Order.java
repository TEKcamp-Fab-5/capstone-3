package inventory.manager.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;

    // No idea how to do this

//    @ManyToOne
//    private Product product;
//
//    @OneToOne
//    private OrderDetail orderDetail;
//
//    @OneToMany
//    private Account account;
}
