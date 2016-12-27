package lorrywork.emall.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lorrywork.emall.entity.UserModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller  
@RequestMapping("/user")  
public class DemoController {  
  private Logger logger = LoggerFactory.getLogger(DemoController.class);  
  
  @RequestMapping(value = "/list", method = RequestMethod.POST)  
  @ResponseBody  
  public String getUserList() {  
    logger.info("列表");  
    List<UserModel> list = new ArrayList<UserModel>();  
    UserModel um = new UserModel();  
    um.setId("1");  
    um.setUsername("sss");  
    um.setAge(222);  
    list.add(um);  
    Map<String, Object> modelMap = new HashMap<String, Object>(3);  
    modelMap.put("total", "1");  
    modelMap.put("data", list);  
    modelMap.put("success", "true");
    Gson gson = new Gson();
    
    return gson.toJson(modelMap);
  }
  
  @RequestMapping(value = "/add", method = RequestMethod.POST)  
  @ResponseBody  
  public Map<String, String> addUser(@RequestBody UserModel model) {  
    logger.info("新增");  
    logger.info("捕获到前台传递过来的Model，名称为：" + model.getUsername());  
    Map<String, String> map = new HashMap<String, String>(1);  
    map.put("success", "true");  
    return map;  
  }  
}  
