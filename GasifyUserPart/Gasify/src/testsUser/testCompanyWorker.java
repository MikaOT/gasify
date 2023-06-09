package testsUser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import classGroupUser.CompanyWorker;

class testCompanyWorker {

	@Test
	void testGetIdWorker() {
		CompanyWorker CW1 = new CompanyWorker("C1BJK43","Unknown", "Gas");
		Assert.assertTrue(CW1.getIdWorker() == "C1BJK43");
		
	}
	@Test
	void testSetIdWorker() {
		CompanyWorker CW1 = new CompanyWorker("AABJS73","+XX XXX XXX XXX", "Santander");
		
		CW1.setIdWorker("C1BJK43");
		Assert.assertTrue(CW1.getIdWorker()== "C1BJK43");
	}
	@Test
	void testToString() {
		CompanyWorker CW1 = new CompanyWorker("AABJS73","+XX XXX XXX XXX", "Santander");
		CW1.toString();

	}
}
