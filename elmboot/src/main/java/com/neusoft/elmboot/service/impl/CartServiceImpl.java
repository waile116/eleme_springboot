package com.neusoft.elmboot.service.impl;

import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.CartMapper;
import com.neusoft.elmboot.po.Cart;
import com.neusoft.elmboot.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<Cart> listCart(Cart cart) {
		return cartMapper.listCart(cart);
	}

	@Override
	public int cartOperation(Cart cart, String operation) {
		switch (operation) {
			case "update":
				return cartMapper.updateCart(cart);
			case "remove":
				return cartMapper.removeCart(cart);
			case "save":
				return cartMapper.saveCart(cart);
			default:
				throw new IllegalArgumentException("Invalid cart operation type: " + operation);
		}
	}
}