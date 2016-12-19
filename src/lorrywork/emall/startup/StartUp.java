package lorrywork.emall.startup;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lorrywork.emall.dao.TopMapper;
import lorrywork.emall.entity.Product;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class StartUp implements ServletContextListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Autowired
	private TopMapper topMapper;
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.debug("初始化，加载Top产品");
		List<Product> lst = topMapper.getTopList();
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.connect();
		Pipeline pl = jedis.pipelined();
		for(Product p : lst){
			pl.hset(p.getId() + "", "introduction", p.getIntroduction());
			pl.hset(p.getId() + "", "name", p.getName());
			pl.hset(p.getId() + "", "picUrl", p.getPicUrl());
			pl.hset(p.getId() + "", "categoryId", p.getCategoryId() + "");
			pl.hset(p.getId() + "", "price", p.getPrice() + "");
		}
		
		jedis.close();
	}
}
