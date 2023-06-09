package testsUser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import classGroupUser.AdminUser;
import classGroupUser.CompanyWorker;


class testAdminUser {

	@Test
	void testIsAdmin() {
		AdminUser A1 = new AdminUser();
		
		Assert.assertFalse(A1.isUserAdmin());
	
	}
	@Test
	void testSetIsAdmin() {
		AdminUser A1 = new AdminUser();
		
		A1.setAdmin(false);
		Assert.assertTrue(A1.isUserAdmin()== false);
	}
}
