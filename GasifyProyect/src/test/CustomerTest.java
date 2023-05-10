package test;

import main.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {


    @Test
    void CustomerNAme(){

        Customer customer1 = new Customer("Daniel","76787654X","Santander");
        String nombreCustomer1 = customer1.getName();
        Assertions.assertEquals(nombreCustomer1,"Daniel");

    }

}
