package lorrywork.emall.startup;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import lorrywork.emall.dao.TopMapper;
import lorrywork.emall.entity.Product;
import redis.clients.jedis.Jedis;

public class StartUp implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Autowired
	private TopMapper topMapper;
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		List<Product> lst = topMapper.getTopList();
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("name", "lorry");
	}
	
}
