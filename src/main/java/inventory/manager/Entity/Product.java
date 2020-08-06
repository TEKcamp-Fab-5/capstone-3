package inventory.manager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productSerial;

    //    @Column(nullable = false)
    private Long sku;

    //    @Column(nullable = false)
    private String name;

    //    @Column(nullable = false)
    private double price;

    //    @Column(nullable = false)
    private String category;

    //    @Column(nullable = false)
    private int quantityInInventory;

    //    @Column(nullable = false)
    private String image;

    //    @Column(nullable = false)
    private String manufacturer;

    public Product(Long sku, String name, double price, String category, int quantityInInventory, String image,
                   String manufacturer) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantityInInventory = quantityInInventory;
        this.image = image;
        this.manufacturer = manufacturer;
    }

    public Product() {
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

    public int getQuantityInInventory() {
        return quantityInInventory;
    }

    public void setQuantityInInventory(int quantity_in_inventory) {
        this.quantityInInventory = quantity_in_inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }
}
