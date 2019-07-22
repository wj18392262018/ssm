package com.wj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wj.entity.Product;
import com.wj.mapper.IProductMapper;
@Service("productService")
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductMapper productMapper;
	public List<Product> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		//·ÖÒ³
		PageHelper.startPage(page, size);
		return productMapper.findAll();
	}
	public int save(Product product) {
		// TODO Auto-generated method stub
		return productMapper.save(product);
	}
	//É¾³ý
	public int deleteByIds(String[] ids) {
		// TODO Auto-generated method stub
		return productMapper.deleteByIds(ids);
	}

}
