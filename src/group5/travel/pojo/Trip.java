package group5.travel.pojo;

public class Trip {
	/*
	 * 行程详情表
	 * 
	 *  tripId 	行程编号
		tripName 行程名称
		tripDesc 行程概述
		tripDest 目的地
		experience 专属体验
		tripHotel 推荐酒店
		tripCost 行程费用
		costInclude 费用包含
		costUnInclude 费用不含
		reserveNote  预定须知
		tripImg 商品页面显示的图片
		tripDetail 行程详情
		meunId 主题编号
	 */
	private int tripId	;
	private String tripName	;
	private String tripDesc	;
	private String tripDest	;
	private int tripDays;
	private String experience	;
	private String tripDetail	;
	private String tripHotel	;
	private int tripCost	;
	private String costInclude	;
	private String costUnInclude ;
	private String reserveNote	;
	private String tripImg ;
	private int tripMenu;
	private String menuDesc;
	public int getTripDays() {
		return tripDays;
	}
	public void setTripDays(int tripDays) {
		this.tripDays = tripDays;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
	public int getTripMenu() {
		return tripMenu;
	}
	public void setTripMenu(int tripMenu) {
		this.tripMenu = tripMenu;
	}
	public String getTripImg() {
		return tripImg;
	}
	public void setTripImg(String tripImg) {
		this.tripImg = tripImg;
	}
	
	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public String getTripDesc() {
		return tripDesc;
	}
	public void setTripDesc(String tripDesc) {
		this.tripDesc = tripDesc;
	}
	public String getTripDest() {
		return tripDest;
	}
	public void setTripDest(String tripDest) {
		this.tripDest = tripDest;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getTripDetail() {
		return tripDetail;
	}
	public void setTripDetail(String tripDetail) {
		this.tripDetail = tripDetail;
	}
	public String getTripHotel() {
		return tripHotel;
	}
	public void setTripHotel(String tripHotel) {
		this.tripHotel = tripHotel;
	}
	public int getTripCost() {
		return tripCost;
	}
	public void setTripCost(int tripCost) {
		this.tripCost = tripCost;
	}
	public String getCostInclude() {
		return costInclude;
	}
	public void setCostInclude(String costInclude) {
		this.costInclude = costInclude;
	}
	public String getCostUnInclude() {
		return costUnInclude;
	}
	public void setCostUnInclude(String costUnInclude) {
		this.costUnInclude = costUnInclude;
	}
	public String getReserveNote() {
		return reserveNote;
	}
	public void setReserveNote(String reserveNote) {
		this.reserveNote = reserveNote;
	}
	

}
