package lesson39.controller;

import java.util.Set;
import java.util.stream.Collectors;
import lesson38.dto.CustomerResponse;
import lesson38.entity.Customer;
import lesson39.service.AdditionalCustomerServiceRealDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spasko
 */

@RestController
@RequestMapping("/additional/customers")
public class AdditionalCustomerController {
    private static final Logger LOG = LoggerFactory.getLogger(AdditionalCustomerController.class);

    private final AdditionalCustomerServiceRealDb additionalCustomerService;
    private final ConversionService conversionService;

    public AdditionalCustomerController(AdditionalCustomerServiceRealDb additionalCustomerService,
            ConversionService conversionService) {
        this.additionalCustomerService = additionalCustomerService;
        this.conversionService = conversionService;
    }

    @GetMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> getCustomerByOrderId(@RequestParam("orderId") int orderNumber) {
        LOG.info("getCustomerByOrderId start, id={}", orderNumber);
        Customer customer = additionalCustomerService.getCustomerByOrderNumber(orderNumber);
        CustomerResponse customerResponse = conversionService.convert(customer, CustomerResponse.class);
        LOG.info("getCustomerByOrderId end");
        if (customer == null) {
            return ResponseEntity.notFound()
                    .build();
        } else {
            return ResponseEntity.ok(customerResponse);
        }
    }

    @GetMapping
    public Set<CustomerResponse> getAllCustomersByName(@RequestParam("customerName") String customerName) {
        LOG.info("getAllCustomersByName start");
        Set<CustomerResponse> customerResponses = additionalCustomerService.getCustomersByName(customerName)
                .stream()
                .map(customer -> conversionService.convert(customer, CustomerResponse.class))
                .collect(Collectors.toSet());

        LOG.info("getAllCustomersByName end");
        return customerResponses;
    }

    @GetMapping(path = "/orders")
    public Page<CustomerResponse> getCustomersWithOrders(Pageable pageable) {
        LOG.info("getCustomersWithOrders start, with {}", pageable);
        Page<Customer> pageCustomers = additionalCustomerService.getCustomersWithOrders(pageable);

        LOG.info("getCustomersWithOrders end {}", pageCustomers.getContent().size());
        return pageCustomers.map(c -> conversionService.convert(c, CustomerResponse.class));
    }

}
