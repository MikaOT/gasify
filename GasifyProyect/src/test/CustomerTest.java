package test;

import main.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {


  @Test
  void ValidateNewCustomer () {

    Customer Customer1 = new Customer();
    Customer1.setIdCustomer("0001");
    Assertions.assertEquals(Customer1.getIdCustomer(), "0001");

  }


  @Test
  void ValidateNameCustomer () {

    Customer Customer1 = new Customer("312","Pedro","667874934","Peñacastillo");

    Assertions.assertEquals(Customer1.getNameCustomer(), "Pedro");

  }

}
