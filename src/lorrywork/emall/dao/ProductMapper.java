package lorrywork.emall.dao;

import java.util.List;

import lorrywork.emall.entity.Product;

public interface ProductMapper {
	public void insertProduct(Product product);
	public List<Product> getProducts();
}
