package com.wj.service;

import java.util.List;

import com.wj.entity.Product;

public interface IProductService {
	//��ѯ����
	public List<Product> findAll(Integer page,Integer size);
	//���
	public int save(Product product);
	//ɾ��
	public int deleteByIds(String[] ids);
}
