package group5.travel.pojo;

/*
 * 订单表
 * orderId 订单编号
startTime  出发时间
adultNum  成人人数
childNum   儿童人数
orderStatus   是否付款
userId  下单用户编号
tripId  订单对应行程编号
 */
public class Order {
	private int orderId ; 
	private String startTime ;
	private String createTime;
	private int adultNum ;
	private int childNum ;
	private int orderStatus;
	private int userId;
	private int tripId;
	private int tripMenu;
	private double orderCost;
	private String tripName;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getAdultNum() {
		return adultNum;
	}
	public void setAdultNum(int adultNum) {
		this.adultNum = adultNum;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getTripMenu() {
		return tripMenu;
	}
	public void setTripMenu(int tripMenu) {
		this.tripMenu = tripMenu;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", startTime=" + startTime + ", createTime=" + createTime + ", adultNum="
				+ adultNum + ", childNum=" + childNum + ", orderStatus=" + orderStatus + ", userId=" + userId
				+ ", tripId=" + tripId + ", tripMenu=" + tripMenu + ", orderCost=" + orderCost + ", tripName="
				+ tripName + "]";
	}
	
}
