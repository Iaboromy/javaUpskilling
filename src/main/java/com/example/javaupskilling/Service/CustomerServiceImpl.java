package com.example.javaupskilling.Service;

import ch.qos.logback.core.CoreConstants;
import com.example.javaupskilling.Exceptions.ApiRequestException;
import com.example.javaupskilling.Model.CustomerModel;
import com.example.javaupskilling.Repository.CustomerRepo;
import com.sun.media.jfxmedia.logging.Logger;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;

    public CustomerServiceImpl (CustomerRepo customerRepo){
        super();
        this.customerRepo = customerRepo;
    }


    @Override
    public List<CustomerModel> get() {
        return customerRepo.findAll();
    }

    @Override
    @Transactional
    public List<CustomerModel> findByCustomerNumber(String id) {
        return customerRepo.findCustomerModelByCustomerNumber(id);
    }

    @Override
    public Optional<CustomerModel> post(CustomerModel request) {
        UUID uuid = UUID.randomUUID();
        if(request.getCustomerEmail() == null){
            throw new ApiRequestException("Email is a required field");
        }
        else if(request.getCustomerName() == null){
            throw new ApiRequestException("Customer name is a required field");
        }
        else if(request.getCustomerMobile() == null){
            throw new ApiRequestException("Customer mobile is a required field");
        }
        else if(request.getAddress1() == null){
            throw new ApiRequestException("Address 1 is a required field");
        }
        else if(request.getAccountType() == null){
            throw new ApiRequestException("Account Type is a required field");
        }
        else if(!request.getAccountType().equalsIgnoreCase("S")
                || request.getAccountType().equalsIgnoreCase("C")){
            throw new ApiRequestException("Account Type must be S-Savings or C-Checking only");
        }
        else {
            try {
                request.setCustomerNumber(String.valueOf(uuid));
                customerRepo.save(request);
                return customerRepo.findById(request.getId());
            }
            catch (Exception e){
                throw new ApiRequestException("Unhandled Error");
            }
        }
    }


}
