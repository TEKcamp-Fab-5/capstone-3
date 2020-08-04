package inventory.manager.Services;

import inventory.manager.DTO.ProductDTO;
import inventory.manager.Entity.Product;

import java.util.List;


public interface IProductService {


    ProductDTO createProduct(ProductDTO productDTO);

    List<Product> getProducts();
}
