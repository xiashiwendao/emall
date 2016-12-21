package lorrywork.emall.startup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;

import lorrywork.emall.base.CUtils;
import lorrywork.emall.base.ConfigProperties;
import lorrywork.emall.base.Cosnts;
import lorrywork.emall.base.DbUtils;
import lorrywork.emall.dao.TopMapper;
import lorrywork.emall.entity.Product;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class StartUp implements ServletContextListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	// @Autowired
	// private TopMapper topMapper;

	@Autowired
	private TopMapper topMapper;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			logger.debug("初始化，加载Top产品");
			List<Product> lst = getTopList();
			logger.debug("发现了{}个Top产品", lst.size());
			Jedis jedis = new Jedis("127.0.0.1", 6379);
			jedis.connect();
			Pipeline pl = jedis.pipelined();
			for (Product p : lst) {
				pl.hset(Cosnts.TOP_PREFIX + p.getId() + "", "introduction", p.getIntroduction());
				pl.hset(Cosnts.TOP_PREFIX + p.getId() + "", "name", p.getName());
				pl.hset(Cosnts.TOP_PREFIX + p.getId() + "", "picUrl", p.getPicUrl());
				pl.hset(Cosnts.TOP_PREFIX + p.getId() + "", "categoryId", p.getCategoryId() + "");
				pl.hset(Cosnts.TOP_PREFIX + p.getId() + "", "price", p.getPrice() + "");
			}

			jedis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Product> getTopList() {
		List<Product> ret = new ArrayList<Product>();
		String url = ConfigProperties.getInstance().getPropValue("url");
		String uid = ConfigProperties.getInstance().getPropValue("uid");
		String pwd = ConfigProperties.getInstance().getPropValue("pwd");
		Connection conn = DbUtils.getConnect(url, uid, pwd);
		String sql = " select  * from top t	join product p on t.productId = p.id";
		try {
			ResultSet set = DbUtils.execSqlForList(conn, sql);
			while (set.next()) {
				Product p = new Product();
				p.setId(set.getInt("id"));
				p.setCategoryId(set.getInt("categoryId"));
				p.setIntroduction(set.getString("introduction"));
				p.setName(set.getString("name"));
				p.setPicUrl(set.getString("picUrl"));
				p.setPrice(set.getDouble("price"));

				ret.add(p);
			}
		} catch (Exception e) {
			CUtils.HandleEx(logger, e);
		}

		return ret;
	}
}
