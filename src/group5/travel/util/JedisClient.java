package group5.travel.util;

import java.util.List;
import java.util.Set;

/**  
* @ClassName: JedisTool  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年11月30日 下午3:23:00    
* Company www.igeekhome.com
*    
*/
public interface JedisClient {
	public String set(String key,String value);
	public String get(String key);
	public long del(String key);
	public Set<String> keys(String patten);
	public String flushall();
	public long hset(String key,String field,String values);
	public String mset(String... keysvalues);
	public String hget (String key, String field);
	public List<String> mget(String ... keys);
	public List<String> hmget(String key,String ... field);
	public long expire(String key,int second);
	public long ttl(String key);
	public long persist(String key);
	public boolean exists(String key);
	public boolean hexists(String key,String field);
	public long incr(String key);
	public long decr(String key);
}
