package edu.pe.cibertec.advance;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements  CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
