package com.example.demodocker;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController
{
    @RequestMapping("/customers")

    public List<Customer> findAll()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer(1, "frank"));
        customerList.add(new Customer(2, "john"));
        customerList.add(new Customer(3, "SRINIVAS"));
        return customerList;
    }
}