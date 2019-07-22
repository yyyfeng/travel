package group5.travel.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**  
* @ClassName: JSONUtils  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年11月28日 上午10:07:55    
* Company www.igeekhome.com
*    
*/
public class JSONUtils {
	
	
	
	/**
	 * 将对象转换为json
	* @Title: ObejcToJson  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param obj
	* @return
	 */
	public static String ObejcToJson(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 将json转换为对象
	* @Title: JsonToObject  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param json
	* @param cls
	* @return
	 */
	public static <T> T JsonToObject(String json,Class<T> cls) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			T t = mapper.readValue(json, cls);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	* @Title: JsonToList  
	* @Description: 将json转换为一个arrayList
	* @param json
	* @param cls
	* @return
	 */
	public static <T> List<T> JsonToList(String json,Class<T> cls){
		List<T> list = null;
		ObjectMapper mapper = new ObjectMapper();
		JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, cls);
		try {
			list = mapper.readValue(json, jt);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}	
