package com.example.javaupskilling.Controller;

import com.example.javaupskilling.Model.CustomerModel;
import com.example.javaupskilling.Service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path ="/")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl){
        super();
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping(path = "/api/getall")
    @ResponseBody
    public ResponseEntity<List<CustomerModel>> getAll(){
        List<CustomerModel> customerList = customerServiceImpl.get();
        return new ResponseEntity<List<CustomerModel>>(customerList, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/account/{customerNumber}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("customerNumber") String id){
        List<CustomerModel> list = customerServiceImpl.findByCustomerNumber(id);
        return new ResponseEntity<>(list ,HttpStatus.OK);
    }


    @PostMapping(path ="api/v1/account", consumes = {"application/json"})
    public ResponseEntity<?> customerRegistration(@RequestBody CustomerModel customerRegistration){
        Map<String, String> data = new HashMap<>();

        try {
            Optional<CustomerModel> customerList = customerServiceImpl.post(customerRegistration);
            data.put("customerNumber",String.valueOf(customerList.get().getId()));
            data.put("transactionCode",String.valueOf(HttpStatus.CREATED.value()));
            data.put("transactionDescription", "Customer Account Created");
        }
        catch (Exception e){
            data.put("transactionCode",String.valueOf(HttpStatus.BAD_REQUEST.value()));
            data.put("transactionDescription",e.getMessage());
        }

        return new ResponseEntity<>(data,HttpStatus.OK);
    }
}
