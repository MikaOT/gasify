package classGroupUser;

public class CompanyWorker extends AdminUser {

	private String idWorker;
	private String companyName;
	private String area;
	
	public CompanyWorker() {
		super();
		idWorker = "Unknown";
		companyName = "Unknown";
		area = "Unknown";
	}
	
	public CompanyWorker(String idWorker, String companyName, String area) {
		super();
		this.idWorker = idWorker;
		this.companyName = companyName;
		this.area = area;
	}

	public String getIdWorker() {
		return idWorker;
	}

	public void setIdWorker(String idWorker) {
		this.idWorker = idWorker;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "CompanyWorker [idWorker=" + idWorker + ", companyName=" + companyName + ", area=" + area + "]";
	}
	
	
	
}
