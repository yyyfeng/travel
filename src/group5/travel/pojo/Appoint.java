package group5.travel.pojo;

public class Appoint {
private	int appointId;  
	private String appointName;
	private String appointTel;
	private String appointDest;	
	private String  appointDay;
	private String appointTime;	
	private int appointAdult;
	private int appointChild;
	private int appointStatus;
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAppointId() {
		return appointId;
	}
	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}
	public String getAppointName() {
		return appointName;
	}
	public void setAppointName(String appointName) {
		this.appointName = appointName;
	}
	public String getAppointTel() {
		return appointTel;
	}
	public void setAppointTel(String appointTel) {
		this.appointTel = appointTel;
	}
	public String getAppointDest() {
		return appointDest;
	}
	public void setAppointDest(String appointDest) {
		this.appointDest = appointDest;
	}
	public String getAppointDay() {
		return appointDay;
	}
	public void setAppointDay(String appointDay) {
		this.appointDay = appointDay;
	}
	public String getAppointTime() {
		return appointTime;
	}
	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}
	public int getAppointAdult() {
		return appointAdult;
	}
	public void setAppointAdult(int appointAdult) {
		this.appointAdult = appointAdult;
	}
	public int getAppointChild() {
		return appointChild;
	}
	public void setAppointChild(int appointChild) {
		this.appointChild = appointChild;
	}
	public int getAppointStatus() {
		return appointStatus;
	}
	public void setAppointStatus(int appointStatus) {
		this.appointStatus = appointStatus;
	}
	@Override
	public String toString() {
		return "Appoint [appointId=" + appointId + ", appointName=" + appointName + ", appointTel=" + appointTel
				+ ", appointDest=" + appointDest + ", appointDay=" + appointDay + ", appointTime=" + appointTime
				+ ", appointAdult=" + appointAdult + ", appointChild=" + appointChild + ", appointStatus="
				+ appointStatus + "]";
	}
	public Appoint(int appointId, String appointName, String appointTel, String appointDest, String appointDay,
			String appointTime, int appointAdult, int appointChild, int appointStatus) {
		super();
		this.appointId = appointId;
		this.appointName = appointName;
		this.appointTel = appointTel;
		this.appointDest = appointDest;
		this.appointDay = appointDay;
		this.appointTime = appointTime;
		this.appointAdult = appointAdult;
		this.appointChild = appointChild;
		this.appointStatus = appointStatus;
	}
	public Appoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
