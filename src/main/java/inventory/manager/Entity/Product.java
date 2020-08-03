package inventory.manager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_serial;

    private String name;

    private double price;

    private String category;

    private int quantity_in_inventory;

    private String image;

    public Long getProduct_serial() {
        return product_serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity_in_inventory() {
        return quantity_in_inventory;
    }

    public void setQuantity_in_inventory(int quantity_in_inventory) {
        this.quantity_in_inventory = quantity_in_inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(String name, double price, String category, int quantity_in_inventory, String image) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity_in_inventory = quantity_in_inventory;
        this.image = image;
    }

    public Product() {
    }
}
