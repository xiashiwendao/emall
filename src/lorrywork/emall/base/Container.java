package lorrywork.emall.base;

import redis.clients.jedis.Jedis;

public class Container {
	private static Jedis jedis = null;
	private static Object objForJedis = new Object();

	public static Jedis getJedis() {
		if (jedis == null) {
			synchronized (objForJedis) {
				String redisIp = ConfigProperties.getInstance().getPropValue("redis.ip");
				int port = Integer.parseInt(ConfigProperties.getInstance().getPropValue("redis.port"));

				jedis = new Jedis(redisIp, port);
			}
		}

		return jedis;
	}
}
