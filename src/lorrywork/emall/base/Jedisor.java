package lorrywork.emall.base;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class Jedisor {
	private Jedis jedis = null;

	public Jedisor() {
		String redisIp = ConfigProperties.getInstance().getPropValue("redis.ip");
		int port = Integer.parseInt(ConfigProperties.getInstance().getPropValue("redis.port"));
		jedis = new Jedis(redisIp, port);

		jedis.connect();
	}

	private static Jedisor jedisor = null;
	private static Object objForJedis = new Object();

	public static Jedisor instance() {
		if (jedisor == null) {
			synchronized (objForJedis) {
				jedisor = new Jedisor();
			}
		}

		return jedisor;
	}

	public Long hset(String key, String field, String value) {
		return this.jedis.hset(key, field, value);
	}

	public Pipeline getPipelined() {
		return this.jedis.pipelined();
	}
	
	public void mulit(){
		this.jedis.multi();
	}
}
