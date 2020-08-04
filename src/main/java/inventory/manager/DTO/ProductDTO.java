package inventory.manager.DTO;

public class ProductDTO {

    private Long productSerial;
    private String name;
    private String manufacture;
    private double price;
    private int quantity;

    public ProductDTO() {
    }
    public ProductDTO(Long productSerial, String name, String manufacture, double price, int quantity) {
        this.productSerial = productSerial;
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
