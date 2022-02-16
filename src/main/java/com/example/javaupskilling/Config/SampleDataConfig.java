package com.example.javaupskilling.Config;

import com.example.javaupskilling.Model.CustomerModel;
import com.example.javaupskilling.Repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SampleDataConfig {

//    @Bean
//    CommandLineRunner cmdr (CustomerRepo customerRepo) {
//        return args -> {
//            List<CustomerModel> customerList = new ArrayList<>();
//            CustomerModel custList = new CustomerModel("testname","0912345662","testemail1","testaddress1","testaddress2","S");
//            customerList.add(custList);
//        };
//    }
}
