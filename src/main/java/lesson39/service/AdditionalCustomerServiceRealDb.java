package lesson39.service;

import java.util.Set;
import lesson38.entity.Customer;
import lesson39.repository.CustomerCrudRepository;
import lesson39.repository.CustomerPageAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdditionalCustomerServiceRealDb {
    private final CustomerCrudRepository customerCrudRepository;
    private final CustomerPageAndSortingRepository customerPageAndSortingRepository;

    public AdditionalCustomerServiceRealDb(CustomerCrudRepository customerCrudRepository,
            CustomerPageAndSortingRepository customerPageAndSortingRepository) {
        this.customerCrudRepository = customerCrudRepository;
        this.customerPageAndSortingRepository = customerPageAndSortingRepository;
    }

    public Set<Customer> getCustomersByName(String customerName) {
        return customerCrudRepository.findByCustomerName(customerName);
    }

    public Customer getCustomerByOrderNumber(int orderNumber) {
        return customerCrudRepository.getByOrderNumber(orderNumber);
        //return customerCrudRepository.findByOrders_OrderNumber(orderNumber);
    }

    public Page<Customer> getCustomersWithOrders(Pageable pageable) {
        return customerPageAndSortingRepository.findDistinctCustomerByOrders_OrderNumberIsNotNull(pageable);
    }
}
