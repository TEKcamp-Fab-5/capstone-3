package inventory.manager.Response;

import java.util.Objects;

public class ProductResponse {

    private Long productSerial;
    private Long sku;
    private String name;
    private String manufacturer;
    private String category;
    private double price;
    private int quantityInInventory;
    private String image;

    public ProductResponse() {
    }

    public ProductResponse(Long productSerial, Long sku, String name, String manufacturer, String category, double price, int quantityInInventory, String image) {
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

    private boolean isEquals(double thisDouble, double comparatorDouble) {
        return thisDouble == comparatorDouble;
    }

    private boolean isEquals(Long thisLong, Long comparatorLong) {
        return Objects.equals(thisLong, comparatorLong);
    }

    private boolean isEquals(String thisString, String comparatorString) {
        return Objects.equals(thisString, comparatorString);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        ProductResponse comparator = (ProductResponse) obj;
        if (Objects.equals(this.getProductSerial(), comparator.getProductSerial()) &&
                Objects.equals(this.getSku(), comparator.getSku())) {
            return true;
        }
        boolean equals = isEquals(this.getCategory(), comparator.getCategory());
        equals &= isEquals(this.getManufacturer(), comparator.getManufacturer());
        equals &= isEquals(this.getName(), comparator.getName());
        equals &= isEquals(this.getPrice(), comparator.getPrice());
        equals &= isEquals(this.getProductSerial(), comparator.getProductSerial());
        equals &= isEquals(this.getSku(), comparator.getSku());
        return equals;
    }

    @Override
    public String toString() {
        return String.format("Sku: %d | Serial: %d", getSku(), getProductSerial());
    }
}
