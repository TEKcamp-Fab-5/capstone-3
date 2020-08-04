package inventory.manager.Services.Implementation;


import inventory.manager.DAO.IProductRepository;
import inventory.manager.DTO.ProductDTO;
import inventory.manager.Entity.Product;
import inventory.manager.Request.ProductRequest;
import inventory.manager.Services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements IProductService {

    private final IProductRepository productRepository;

    public ProductServiceImplementation(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product newProduct = new Product();
        BeanUtils.copyProperties(productDTO, newProduct);
        Product storedProductDetails = productRepository.save(newProduct);
        ProductDTO returnValue = new ProductDTO();
        BeanUtils.copyProperties(storedProductDetails, returnValue);

        return returnValue;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> returnValue;
        returnValue = (List<Product>) productRepository.findAll();

        return returnValue;
    }

    @Override
    public Product getProductBySerial(Long productSerial) {
        Product returnValue = productRepository.findByProductSerial(productSerial);
        return returnValue;
    }

    @Override
    public ProductDTO updateProduct(ProductRequest productRequest, ProductDTO queriedProductDTO) {
        //5
        queriedProductDTO.setSku(productRequest.getSku());
        queriedProductDTO.setName(productRequest.getName());
        queriedProductDTO.setManufacturer(productRequest.getManufacturer());
        queriedProductDTO.setCategory(productRequest.getCategory());
        queriedProductDTO.setPrice(productRequest.getPrice());
        queriedProductDTO.setQuantityInInventory(productRequest.getQuantityInInventory());
        queriedProductDTO.setImage(productRequest.getImage());

        ProductDTO returnValue = new ProductDTO();
        BeanUtils.copyProperties(queriedProductDTO, returnValue);

        return returnValue;
    }
}
