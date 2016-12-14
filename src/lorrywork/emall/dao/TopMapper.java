package lorrywork.emall.dao;

import java.util.List;

import lorrywork.emall.entity.Product;

public interface TopMapper {
	List<Product> getTopList();
}
