package lorrywork.emall.controller.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lorrywork.emall.dao.TopMapper;
import lorrywork.emall.entity.Product;

@Controller
public class TopController {
	@Autowired
	private TopMapper mapper;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/top")
	public ModelAndView showTopPage(ModelAndView model) {
		logger.debug("进入到首页面");
		//List<Product> lst = mapper.getTopList();
		//model.addObject("topList", lst);
		model.setViewName("/top/top");

		return model;
	}
}