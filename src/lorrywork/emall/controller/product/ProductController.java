package lorrywork.emall.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lorrywork.emall.base.Container;
import lorrywork.emall.base.Jedisor;
import lorrywork.emall.dao.ProductMapper;
import lorrywork.emall.domain.KeywordManager;
import lorrywork.emall.entity.Product;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private ProductMapper mapper;

	@RequestMapping(value = "/product")
	public ModelAndView getProductDetail(ModelAndView model) {
		List<Product> lst = mapper.getProducts();
		Product p = lst.get(0);
		logger.debug("图片路径：{}", p.getPicUrl());

		model.addObject("product", p);
		model.setViewName("product/productDetail");
		return model;
	}

	@Autowired
	private KeywordManager keyMgr;

	@RequestMapping(value = "/search")
	@ResponseBody
	public String seachProduct(String keyword) {
		logger.debug("/P/ keyword: {}", keyword);
		//keyMgr.addKeyword(keyword);

		Map<String, String> ret = new HashMap<String, String>();
		ret.put("name", "About");
		ret.put("name1", "Bep");
		ret.put("name2", "City");

		return "abc";
	}
}
