package lorrywork.emall.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lorrywork.emall.base.ConfigProperties;
import lorrywork.emall.base.Container;
import lorrywork.emall.base.Jedisor;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

@Service
public class KeywordManager {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public KeywordManager() {

	}

	public void addKeyword(String keyword) {
		String keywordPY = this.getPinyin(keyword);
		// String keywordHead = this.getPinyin(keyword);
		// Jedisor jedis = Jedisor.instance();
		Jedis jedis = Container.getJedis();
		Pipeline pl = jedis.pipelined();
		// TODO 关键字的数据结构还需要进行考虑
		if (!jedis.hexists("kw:" + keyword, "word")) {
			pl.multi();
			jedis.hset("kw:" + keyword, "word", keywordPY);
			pl.exec();
		}
	}

	private String getPinyin(String keyword) {

		return null;
	}

	public Object[] getKeywords(String keyword) {
		logger.debug("关键字: {}", keyword);
		String redisIp = ConfigProperties.getInstance().getPropValue("redis.ip");
		int port = Integer.parseInt(ConfigProperties.getInstance().getPropValue("redis.port"));

		Jedis jedis = new Jedis(redisIp, port);
		Set<String> set = jedis.zrangeByLex("keywords", "[" + keyword, "+", 0, 2);
		jedis.close();
		List<String> lst = new ArrayList<String>();
		for(String item : set){
			if(item.contains(keyword)){
				lst.add(item);
			}
		}
		
		return lst.toArray();
	}
}
