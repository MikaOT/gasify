package classGroupUser;

public class AdminUser extends User {

	private boolean isAdmin;
	
	public void isAdmin() {
		isAdmin = true;
	}
	public boolean isUserAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
