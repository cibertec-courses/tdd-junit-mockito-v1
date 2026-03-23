package edu.pe.cibertec.advance;

public class CustumerNotFoundException extends RuntimeException {
    public CustumerNotFoundException(Long id) {
        super("Customer not found with id: " + id);
    }
}
