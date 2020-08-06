package inventory.manager.DTO;

public class ProductDTO {

    private Long productSerial;
    private Long sku;
    private String name;
    private String manufacturer;
    private String category;
    private double price;
    private int quantityInInventory;
    private String image;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Long productSerial, Long sku, String name, String manufacturer, String category, double price, int quantityInInventory, String image) {
        this.productSerial = productSerial;
        this.sku = sku;
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.quantityInInventory = quantityInInventory;
        this.image = image;
    }

    public Long getProductSerial() {
        return productSerial;
    }

    public void setProductSerial(Long productSerial) {
        this.productSerial = productSerial;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInInventory() {
        return quantityInInventory;
    }

    public void setQuantityInInventory(int quantityInInventory) {
        this.quantityInInventory = quantityInInventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
