package com.capg.msc.MyShoppingCart.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.msc.MyShoppingCart.beans.Product;
import com.capg.msc.MyShoppingCart.dao.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
    
	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public Product saveProduct(Product p) {
		repo.save(p);
		return p;
	}
	
	@Override
	public Product searchProduct(int id) {
		return repo.findById(id).get();
	}
	
	@Override
	public Product updateProduct(Product p, int id) {
		Product product = searchProduct(id);
		product.setProductName(p.getProductName());
		product.setProductCost(p.getProductCost());
		product.setStarRating(p.getStarRating());
		product.setCategory(p.getCategory());
		return repo.save(product);
	}

	@Override
    @Transactional
	public boolean deleteProduct(int id) {
		boolean isdeleted = false;
		repo.deleteById(id);
		isdeleted = true;
		return isdeleted;	
	}
	
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) {
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}
	

}
