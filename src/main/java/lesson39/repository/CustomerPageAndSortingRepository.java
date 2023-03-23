package lesson39.repository;

import lesson38.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPageAndSortingRepository extends PagingAndSortingRepository<Customer, Integer> {
    Page<Customer> findDistinctCustomerByOrders_OrderNumberIsNotNull(Pageable pageable);
}
