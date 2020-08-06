package inventory.manager.Services.Implementation;

import inventory.manager.DAO.IProductRepository;
import inventory.manager.DTO.ProductDTO;
import inventory.manager.Request.ProductRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ProductServiceImplementationTests {
    @Test
    public void testUpdateProduct_quantityIncrements() {
        ProductDTO queriedProductDTO = new ProductDTO();
        IProductRepository repository = Mockito.mock(IProductRepository.class);
        ProductRequest productRequest = new ProductRequest();
        ProductServiceImplementation service = new ProductServiceImplementation(repository);
        int expected = 3;
        int actual = service.updateProduct(productRequest, queriedProductDTO).getQuantityInInventory();
        Assertions.assertEquals(expected, actual);
    }
}
