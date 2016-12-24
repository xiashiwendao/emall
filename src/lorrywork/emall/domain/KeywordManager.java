package lorrywork.emall.domain;

import org.springframework.stereotype.Service;

import lorrywork.emall.base.Container;
import lorrywork.emall.base.Jedisor;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

@Service
public class KeywordManager {
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

	public String getKeywords(String keyword) {
		Jedis jedis = Container.getJedis();
		jedis.hget("kw", keyword + "*");
		return "";
	}
}
