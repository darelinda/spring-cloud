package com.example.billingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

   /* @Bean
    CommandLineRunner Start(BillRepository billRepository, ProductItemRepository productItemRepository) {
        return args -> {
            Bill bill1 = billRepository.save(new Bill(null, new Date(), 1L, null, null));
            productItemRepository.save(new ProductItem(null, 1L, null, 80, 500, bill1));
            productItemRepository.save(new ProductItem(null, 2L, null, 12, 900, bill1));
            productItemRepository.save(new ProductItem(null, 3L, null, 80, 500, bill1));
        };
    }*/


}




