package inventory.manager.DAO;

import inventory.manager.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface IProductRepository extends CrudRepository<Product, Long>, PagingAndSortingRepository<Product, Long>{



}
