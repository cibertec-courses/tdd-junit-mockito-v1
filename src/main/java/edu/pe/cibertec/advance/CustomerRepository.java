package edu.pe.cibertec.advance;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    Optional<Customer> findByEmail(String email);

    Customer save(Customer customer);

    void deleteById(Long id);
}

