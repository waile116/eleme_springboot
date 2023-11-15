package com.neusoft.elmboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neusoft.elmboot.po.Orders;
import com.neusoft.elmboot.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	@PostMapping("/create")
	public int createOrders(Orders orders) throws Exception {
		return ordersService.createOrders(orders);
	}

	@GetMapping("/getById")
	public Orders getOrdersById(Integer orderId) throws Exception {
		return ordersService.getOrdersById(orderId);
	}

	@GetMapping("/listByUserId")
	public List<Orders> listOrdersByUserId(String userId) throws Exception {
		return ordersService.listOrdersByUserId(userId);
	}
}
