package group5.travel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**  
* @ClassName: DateUtil  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年12月6日 上午10:10:56    
* Company www.igeekhome.com
*    
*/
public class DateUtil {
	/**
	 *  将字符串转换日期
	* @Title: getDateFromString  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param str
	* @return
	 */
	public static Date getDateFromString(String str) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//获取系统时间string形式
	public static String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	//获取系统时间string形式
	public static String getDateTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
}
