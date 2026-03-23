package edu.pe.cibertec.advance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    @DisplayName("Returns All customers from repostory")
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

    ///  getCustomerById(Long id):
    @Test
    @DisplayName("Returns customer when ID exists")
    void givenExistingId_whenGetCustomerByID_thenReturnCusotmer() {
        Customer customer = new Customer(1L, "Juan Perez", "jperez@hotmail.com");

        when(repository.findById(1L)).thenReturn(Optional.of(customer));

        Customer result = service.getCustomerById(1L);

        assertEquals("Juan Perez", result.getName());

        verify(repository, times(1)).findById(1L);
    }

    ///  CustomerNotFoundException
    @Test
    @DisplayName("Throws CustomerNotFoundException when ID does not exist ie 1")
    void givenNonExistingId_whenGetCustomerById_thenThrowException() {
        Long id = 100L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> {
            service.getCustomerById(id);
        });
        verify(repository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Throws CustomerNotFoundException when ID does not exist ie 2")
    void givenNonExistingId_whenGetCustomerById_thenThrowsCustomerNotFoundException() {
        when(repository.findById(999L)).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> service.getCustomerById(999L));
        verify(repository, times(1)).findById(999L);
    }

    ///  deleteCustomer
    @Test
    @DisplayName("Should delete customer when ID exists")
    void givenExistingId_whenDeleteCustomer_thenVerifyDeletion() {
        Long id = 1L;
        Customer customer = new Customer(1L, "Juan", "juan@gmail.com");
        when(repository.findById(id)).thenReturn(Optional.of(customer));
        service.deleteCustomer(id);
        verify(repository, times(1)).deleteById(id);
    }

    ///  Throws exception when deleting non-existing ID
    @Test
    @DisplayName("Should throw exception and not delete when ID does not exist")
    void givenNonExistingId_whenDeleteCustomer_thenThrowExceptionAndNoDelete() {
        Long id = 100L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> {
            service.deleteCustomer(id);
        });
        verify(repository, never()).deleteById(id);
    }

    @Test
    @DisplayName("Throws CustomerNotFoundException when deleting not existing ID customer")
    void givenNonExistingId_whenDeleteCustomer_thenThrowsCustomerNotFoundException() {
        when(repository.findById(999L)).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer(999L));
        verify(repository, times(1)).findById(999L);
        verify(repository, times(0)).deleteById(anyLong());

    }



}
