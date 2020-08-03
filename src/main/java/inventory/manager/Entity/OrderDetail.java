package inventory.manager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transaction_serial;

    private String order_date;

    private double sub_total;

    private double tax;

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

    public OrderDetail(String order_date, double sub_total, double tax, double total) {
        this.order_date = order_date;
        this.sub_total = sub_total;
        this.tax = tax;
        this.total = total;
    }

    public OrderDetail() {
    }
}
