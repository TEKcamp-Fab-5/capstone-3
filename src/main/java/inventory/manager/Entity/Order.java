package inventory.manager.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transaction_serial;

//    @Column(nullable = false)
    private String order_date;

//    @Column(nullable = false)
    private double sub_total;

//    @Column(nullable = false)
    private double tax;

//    @Column(nullable = false)
    private double total;

    public Long getTransaction_serial() {
        return transaction_serial;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Order(String order_date, double sub_total, double tax, double total) {
        this.order_date = order_date;
        this.sub_total = sub_total;
        this.tax = tax;
        this.total = total;
    }

    public Order() {
    }
}
