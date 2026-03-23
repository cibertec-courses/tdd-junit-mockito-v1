package edu.pe.cibertec.advance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Activar la extension de mockito.
@ExtendWith(MockitoExtension.class)
@DisplayName("CustomerServiceImpl - Unit Test With Mockito")
public class CustomerServiceImplTest {

    // Crear un Objeto falso  (No Conecta con la BD)
    @Mock
    private CustomerRepository repository;

    // Inyeccion de mock repository.
    @InjectMocks
    private CustomerServiceImpl service;

    @Test
    @DisplayName("Returns All customers  from repostory")
    void giverCustomersExists_whenGetAllCustomers_thenReturnList() {
        // ARRANGE: Prepara la data
        List<Customer> customers = List.of(
                new Customer(1L, "Ana Torres", "ana@gmail.com"),
                new Customer(2L, "Juar Mendez", "jmendez@perusac.com")
        );
        // ACT: Cuando se llame al find all del repository, el mock retorna la lista
        when(repository.findAll()).thenReturn(customers);
        // LLamar al metodo que estamos testeando
        List<Customer> result = service.getAllCustomer();

        // ASSERT:  Verificar el resutlado
        assertEquals(2, result.size());

        // Verificar la llamada del findAll
        verify(repository, times(1)).findAll();

    }

}
