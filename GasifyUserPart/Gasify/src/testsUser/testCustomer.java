package testsUser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import classGroupUser.Customer;

class testCustomer {

	@Test
	void testGetIdCustomer() {
		Customer C1 = new Customer("AABJS73","+XX XXX XXX XXX", "Santander");
		Assert.assertTrue(C1.getIdCustomer() == "AABJS73");
		
	}
	@Test
	void testSetIdCustomer() {
		Customer C1 = new Customer("AABJS73","+XX XXX XXX XXX", "Santander");
		
		C1.setIdCustomer("AABJS73");
		Assert.assertTrue(C1.getIdCustomer()== "AABJS73");
	}
	@Test
	void testToString() {
		Customer C1 = new Customer("AABJS73","+XX XXX XXX XXX", "Santander");
		C1.toString();

	}
}
