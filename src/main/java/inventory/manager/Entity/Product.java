package inventory.manager.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = -7811855693938330414L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productSerial;
  // @Column(nullable = false)
    private String name;
  //  @Column(nullable = false)
    private String manufacture;
  //  @Column(nullable = false)
    private double price;
//   @Column(nullable = false)
    private int quantity;

    public Product() {
    }

    public Product(String name, String manufacture, double price, int quantity) {
        this.name = name;
        this.manufacture = manufacture;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getProductSerial() {
        return productSerial;
    }

    public void setProductSerial(Long productSerial) {
        this.productSerial = productSerial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
