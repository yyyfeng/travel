package group5.travel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**  
* @ClassName: DateUtil  
* @Description: TODO(������һ�仰��������������)
* @date 2018��12��6�� ����10:10:56    
* Company www.igeekhome.com
*    
*/
public class DateUtil {
	/**
	 *  ���ַ���ת������
	* @Title: getDateFromString  
	* @Description: TODO(������һ�仰�����������������)  
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
	
	//��ȡϵͳʱ��string��ʽ
	public static String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	//��ȡϵͳʱ��string��ʽ
	public static String getDateTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
}
