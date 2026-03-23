package edu.pe.cibertec.advance;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomer();

    Optional<Customer> getCustomerById(Long id);

    Optional<Customer> getCustomerByEmail(String email);

    Customer registerCustomer(Customer customer);

    void deleteCustomer(Long id);
}
