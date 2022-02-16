package com.example.javaupskilling.Repository;

import com.example.javaupskilling.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel,Long> {

    List<CustomerModel> findCustomerModelByCustomerNumber(String id);

}
