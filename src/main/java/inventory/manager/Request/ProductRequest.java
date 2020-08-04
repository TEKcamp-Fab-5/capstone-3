package inventory.manager.Request;

public class ProductRequest {

    private Long id;
    private String productSerial;
    private String name;
    private String manufacture;
    private double price;
    private int quantity;

    public ProductRequest() {
    }
    public ProductRequest(Long id, String productSerial, String name, String manufacture, double price, int quantity) {
        this.id = id;
        this.productSerial = productSerial;
        this.name = name;
        this.manufacture = manufacture;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }
    public String getProductSerial() {
        return productSerial;
    }

    public void setProductSerial(String productSerial) {
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
