package service;

import entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="inventory-service")
public interface InventoryServiceClient {
    @GetMapping("/products/{id}?projection=fullCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);
}
