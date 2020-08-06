package inventory.manager.Controller;

import inventory.manager.DAO.IProductRepository;
import inventory.manager.Entity.Product;
import inventory.manager.Request.ProductRequest;
import inventory.manager.Response.ProductResponse;
import inventory.manager.Services.IProductService;
import inventory.manager.Services.Implementation.ProductServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductControllerTests {
    @Test
    public void testUpdateProduct() {
        long productSerial = 999L;
        long sku = 888L;
        int initialQuantity = 2;
        int updatedQuantity = 3;

        Product productToUpdate = new Product();
        productToUpdate.setProductSerial(productSerial);
        productToUpdate.setSku(sku);
        productToUpdate.setQuantityInInventory(initialQuantity);

        ProductRequest request = new ProductRequest();
        request.setProductSerial(productSerial);
        request.setSku(sku);
        request.setQuantityInInventory(updatedQuantity);

        Product updatedProduct = new Product();
        updatedProduct.setProductSerial(productSerial);
        updatedProduct.setSku(sku);
        updatedProduct.setQuantityInInventory(updatedQuantity);

        IProductRepository repository = Mockito.mock(IProductRepository.class);
        when(repository.findByProductSerial(any(Long.class))).thenReturn(productToUpdate);
        when(repository.save(any(Product.class))).thenReturn(updatedProduct);

        IProductService service = new ProductServiceImplementation(repository);

        ProductResponse expected = new ProductResponse();
        expected.setSku(sku);
        expected.setProductSerial(productSerial);

        ProductResponse actual = new ProductController(service, repository).updateProduct(request);
        Assertions.assertEquals(expected, actual);
    }
}
