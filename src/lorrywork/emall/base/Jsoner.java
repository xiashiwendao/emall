package lorrywork.emall.base;

import java.util.Map;

import com.google.gson.Gson;

/**
 * 用于转换JSON
 * 
 * @author Lorry
 *
 */
public class Jsoner {
	private static Gson gson = null;
	
	static {
		gson = new Gson();
	}
	
	public static Map<String, String> getMapFromJson(String json) {
		return gson.fromJson(json, Map.class);
	}
	
	public static <T> String getJson(T obj){
		return gson.toJson(obj, obj.getClass());
	}
	
	public static <T> T getBody(String json, Class<T> classType){
		return gson.fromJson(json, classType);
	}
}
