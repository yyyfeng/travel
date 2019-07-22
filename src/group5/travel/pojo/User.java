package group5.travel.pojo;

public class User {
	/*用户基本信息表:
	 * 
	 * 
	 * userId 	用户编号
		nickName	用户昵称
		userName	用户姓名
		userTel 	用户电话
		userPass	用户登录密码
		UserAge	用户性别
		userBirth	用户生日
		userEmail	用户邮箱
		userSatus   用户状态
	 */
	private int userId;
	private String nickName	;
	private String userName	;
	private String userTel 	;
	private String userPass	;
	private int userAge	; 
	private String userBirth ;
	private String userEmail ;
	private int userStatus;
	private String code;
	private String userImg;
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public User(int userId, String nickName, String userName, String userTel, String userPass, int userAge,
			String userBirth, String userEmail, int userStatus) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.userName = userName;
		this.userTel = userTel;
		this.userPass = userPass;
		this.userAge = userAge;
		this.userBirth = userBirth;
		this.userEmail = userEmail;
		this.userStatus = userStatus;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName + ", userName=" + userName + ", userTel=" + userTel
				+ ", userPass=" + userPass + ", userAge=" + userAge + ", userBirth=" + userBirth + ", userEmail="
				+ userEmail + ", code=" + code + ", userImg=" + userImg + "]";
	}
	
}
