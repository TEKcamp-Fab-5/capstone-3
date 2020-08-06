package inventory.manager.Services;

import inventory.manager.DTO.ProductDTO;
import inventory.manager.Entity.Product;
import inventory.manager.Request.ProductRequest;

import java.util.List;


public interface IProductService {


    ProductDTO createProduct(ProductDTO productDTO);

    List<Product> getProducts();

    Product getProductBySerial(Long productSerial);

    ProductDTO updateProduct(ProductRequest productRequest, ProductDTO queriedProductDTO);

    Product getProductBySku(Long sku);
}
