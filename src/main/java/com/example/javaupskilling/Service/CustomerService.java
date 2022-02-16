package com.example.javaupskilling.Service;

import com.example.javaupskilling.Model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService  {

    public List<CustomerModel> get();
    public List<CustomerModel> findByCustomerNumber(String id);
    public Optional<CustomerModel> post(CustomerModel customerModel);
}
