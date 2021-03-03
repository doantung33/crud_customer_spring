package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceCustomer implements IServiceCustomer{
    private static Map<Integer,Customer>customerMap=new HashMap<>();
    static {
        customerMap.put(1,new Customer(1,"name1","hd","gmail1"));
        customerMap.put(2,new Customer(2,"name2","hd","gmail2"));
        customerMap.put(3,new Customer(3,"name3","hd","gmail3"));
        customerMap.put(4,new Customer(4,"name4","hd","gmail4"));
        customerMap.put(5,new Customer(5,"name5","hd","gmail5"));

    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id,customer);

    }

    @Override
    public void remote(int id) {
        customerMap.remove(id);
    }
}
