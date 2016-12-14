package lorrywork.emall.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lorrywork.emall.dao.ProductMapper;
import lorrywork.emall.entity.Product;

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
}
