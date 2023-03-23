package lesson39.service;

import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import lesson38.entity.Customer;
import lesson38.service.CustomerService;
import lesson39.repository.CustomerCrudRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@Transactional(dontRollbackOn = SQLException.class)
public class CustomerServiceRealDb implements CustomerService {
    private final CustomerCrudRepository customerCrudRepository;

    public CustomerServiceRealDb(CustomerCrudRepository customerCrudRepository) {
        this.customerCrudRepository = customerCrudRepository;
    }

    @Override
    public Set<Customer> getAllCustomers() {
        Set<Customer> customers = new HashSet<>();
        customerCrudRepository.findAll()
                .forEach(customers::add);
        return customers;
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerCrudRepository.findById(id)
                .orElse(null);
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        return customerCrudRepository.save(customer) != null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerCrudRepository.save(customer) != null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        customerCrudRepository.deleteById(id);
        return true;
    }

}
