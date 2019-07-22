package group5.travel.util;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.JedisCluster;

/**  
* @ClassName: ClusterClient  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年12月3日 下午4:26:07    
* Company www.igeekhome.com
*    
*/
public class ClusterClient implements JedisClient {
	private JedisCluster cluster ;
	
	public ClusterClient(JedisCluster cluster) {
		super();
		this.cluster = cluster;
	}

	public void setCluster(JedisCluster cluster) {
		this.cluster = cluster;
	}

	/**  
	* @Title: set  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @param value
	* @return
	* @see day14_demo.JedisClient#set(java.lang.String, java.lang.String)
	*/
	@Override
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		return cluster.set(key, value);
	}

	/**  
	* @Title: get  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#get(java.lang.String)
	*/
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return cluster.get(key);
	}

	/**  
	* @Title: del  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#del(java.lang.String)
	*/
	@Override
	public long del(String key) {
		// TODO Auto-generated method stub
		return cluster.del(key);
	}

	/**  
	* @Title: keys  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param patten
	* @return
	* @see day14_demo.JedisClient#keys(java.lang.String)
	*/
	@Override
	public Set<String> keys(String patten) {
		// TODO Auto-generated method stub
		return null;
	}

	/**  
	* @Title: flushall  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @return
	* @see day14_demo.JedisClient#flushall()
	*/
	@Override
	public String flushall() {
		// TODO Auto-generated method stub
		return cluster.flushAll();
	}

	/**  
	* @Title: hset  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @param field
	* @param values
	* @return
	* @see day14_demo.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	*/
	@Override
	public long hset(String key, String field, String values) {
		// TODO Auto-generated method stub
		return cluster.hset(key, field, values);
	}

	/**  
	* @Title: mset  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param keysvalues
	* @return
	* @see day14_demo.JedisClient#mset(java.lang.String[])
	*/
	@Override
	public String mset(String... keysvalues) {
		// TODO Auto-generated method stub
		return cluster.mset(keysvalues);
	}

	/**  
	* @Title: hget  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @param field
	* @return
	* @see day14_demo.JedisClient#hget(java.lang.String, java.lang.String)
	*/
	@Override
	public String hget(String key, String field) {
		// TODO Auto-generated method stub
		return cluster.hget(key, field);
	}

	/**  
	* @Title: mget  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param keys
	* @return
	* @see day14_demo.JedisClient#mget(java.lang.String[])
	*/
	@Override
	public List<String> mget(String... keys) {
		// TODO Auto-generated method stub
		return cluster.mget(keys);
	}

	/**  
	* @Title: hmget  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @param field
	* @return
	* @see day14_demo.JedisClient#hmget(java.lang.String, java.lang.String[])
	*/
	@Override
	public List<String> hmget(String key, String... fields) {
		// TODO Auto-generated method stub
		return cluster.hmget(key, fields);
	}

	/**  
	* @Title: expire  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @param second
	* @return
	* @see day14_demo.JedisClient#expire(java.lang.String, int)
	*/
	@Override
	public long expire(String key, int seconds) {
		// TODO Auto-generated method stub
		return cluster.expire(key, seconds);
	}

	/**  
	* @Title: ttl  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#ttl(java.lang.String)
	*/
	@Override
	public long ttl(String key) {
		// TODO Auto-generated method stub
		return cluster.ttl(key);
	}

	/**  
	* @Title: persist  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#persist(java.lang.String)
	*/
	@Override
	public long persist(String key) {
		// TODO Auto-generated method stub
		return cluster.persist(key);
	}

	/**  
	* @Title: exists  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#exists(java.lang.String)
	*/
	@Override
	public boolean exists(String key) {
		// TODO Auto-generated method stub
		return cluster.exists(key);
	}

	/**  
	* @Title: hexists  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @param field
	* @return
	* @see day14_demo.JedisClient#hexists(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean hexists(String key, String field) {
		// TODO Auto-generated method stub
		return cluster.hexists(key, field);
	}

	/**  
	* @Title: incr  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#incr(java.lang.String)
	*/
	@Override
	public long incr(String key) {
		return cluster.incr(key);
	}

	/**  
	* @Title: decr  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#decr(java.lang.String)
	*/
	@Override
	public long decr(String key) {
		return cluster.decr(key);
	}

}
