package group5.travel.util;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.JedisPool;

/**  
* @ClassName: JedisPoolClient  
* @Description: TODO(������һ�仰��������������)
* @date 2018��12��3�� ����4:16:10    
* Company www.igeekhome.com
*    
*/
public class JedisPoolClient implements JedisClient {
	
	private JedisPool pool;//��һ��jedisPool��Ϊ��Ա����

	public JedisPoolClient(JedisPool pool) {
		super();
		this.pool = pool;
	}
	
	public void setPool(JedisPool pool) {
		this.pool = pool;
	}

	/**  
	* @Title: set  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @param value
	* @return
	* @see day14_demo.JedisClient#set(java.lang.String, java.lang.String)
	*/
	@Override
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		return pool.getResource().set(key, value);
	}

	/**  
	* @Title: get  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#get(java.lang.String)
	*/
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return pool.getResource().get(key);
	}

	/**  
	* @Title: del  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#del(java.lang.String)
	*/
	@Override
	public long del(String key) {
		// TODO Auto-generated method stub
		return pool.getResource().del(key);
	}

	/**  
	* @Title: keys  
	* @Description: TODO(������һ�仰�����������������)  
	* @param patten
	* @return
	* @see day14_demo.JedisClient#keys(java.lang.String)
	*/
	@Override
	public Set<String> keys(String patten) {
		// TODO Auto-generated method stub
		return pool.getResource().keys(patten);
	}

	/**  
	* @Title: flushall  
	* @Description: TODO(������һ�仰�����������������)  
	* @return
	* @see day14_demo.JedisClient#flushall()
	*/
	@Override
	public String flushall() {
		// TODO Auto-generated method stub
		return pool.getResource().flushAll();
	}

	/**  
	* @Title: hset  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @param field
	* @param values
	* @return
	* @see day14_demo.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	*/
	@Override
	public long hset(String key, String field, String value) {
		// TODO Auto-generated method stub
		return pool.getResource().hset(key, field, value);
	}

	/**  
	* @Title: mset  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @param values
	* @return
	* @see day14_demo.JedisClient#mset(java.lang.String, java.lang.String[])
	*/
	@Override
	public String mset(String... keysvalues) {
		return pool.getResource().mset(keysvalues);
	}

	/**  
	* @Title: hget  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @param field
	* @return
	* @see day14_demo.JedisClient#hget(java.lang.String, java.lang.String)
	*/
	@Override
	public String hget(String key, String field) {
		// TODO Auto-generated method stub
		return pool.getResource().hget(key, field);
	}

	/**  
	* @Title: mget  
	* @Description: TODO(������һ�仰�����������������)  
	* @param keys
	* @return
	* @see day14_demo.JedisClient#mget(java.lang.String[])
	*/
	@Override
	public List<String> mget(String... keys) {
		// TODO Auto-generated method stub
		return pool.getResource().mget(keys);
	}

	/**  
	* @Title: hmget  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @param field
	* @return
	* @see day14_demo.JedisClient#hmget(java.lang.String, java.lang.String[])
	*/
	@Override
	public List<String> hmget(String key, String... fields) {
		// TODO Auto-generated method stub
		return pool.getResource().hmget(key, fields);
	}

	/**  
	* @Title: expire  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @param second
	* @return
	* @see day14_demo.JedisClient#expire(java.lang.String, long)
	*/
	@Override
	public long expire(String key, int seconds) {
		// TODO Auto-generated method stub
		return pool.getResource().expire(key, seconds);
	}

	/**  
	* @Title: ttl  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#ttl(java.lang.String)
	*/
	@Override
	public long ttl(String key) {
		// TODO Auto-generated method stub
		return pool.getResource().ttl(key);
	}

	/**  
	* @Title: persist  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#persist(java.lang.String)
	*/
	@Override
	public long persist(String key) {
		// TODO Auto-generated method stub
		return pool.getResource().persist(key);
	}

	/**  
	* @Title: exists  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#exists(java.lang.String)
	*/
	@Override
	public boolean exists(String key) {
		// TODO Auto-generated method stub
		return pool.getResource().exists(key);
	}

	/**  
	* @Title: hexists  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @param field
	* @return
	* @see day14_demo.JedisClient#hexists(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean hexists(String key, String field) {
		// TODO Auto-generated method stub
		return pool.getResource().hexists(key, field);
	}

	/**  
	* @Title: incr  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#incr(java.lang.String)
	*/
	@Override
	public long incr(String key) {
		return pool.getResource().incr(key);
	}

	/**  
	* @Title: decr  
	* @Description: TODO(������һ�仰�����������������)  
	* @param key
	* @return
	* @see day14_demo.JedisClient#decr(java.lang.String)
	*/
	@Override
	public long decr(String key) {
		return pool.getResource().decr(key);
	}

}
