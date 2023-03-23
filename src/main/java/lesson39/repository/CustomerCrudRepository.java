package lesson39.repository;

import java.util.Set;
import lesson38.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {
    Set<Customer> findByCustomerName(String customerName);
    
    Customer findByOrders_OrderNumber(int orderNumber);
    
    //JPQL example
    @Query("SELECT c FROM Customer c JOIN FETCH c.orders o WHERE o.orderNumber = ?1")
    Customer getByOrderNumber(int orderNumber);
}
