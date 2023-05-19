package classGroupUser;

public class Customer extends RegularUser {
	
	private String idCustomer;
	private String numberPhone;
	private String direccion;
	
	public Customer() {
		super();
		this.idCustomer = "Unknown";
		this.numberPhone = "Unknown";
		this.direccion = "Unknown";
	}
	public Customer(String idCustomer, String numberPhone, String direccion) {
		super();
		this.idCustomer = idCustomer;
		this.numberPhone = numberPhone;
		this.direccion = direccion;
	}
	
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", numberPhone=" + numberPhone + ", direccion=" + direccion + "]";
	}
	
}
