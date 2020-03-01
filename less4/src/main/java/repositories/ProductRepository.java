package repositories;

import entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


    List<Product> findAll();
    List<Product> findByCostLessThanEqual(int Cost);
    List<Product> findByCostGreaterThanEqual(int Cost);
    List<Product> findByCostBetween(int min, int max);


    Product findOneByTitle(String title);
    @Query(value ="select id_Products, title_Products, cost" +
            " from products where id = ?1", nativeQuery = true)
    Product myQuery(Long id);
}
