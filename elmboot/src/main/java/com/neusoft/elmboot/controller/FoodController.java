package com.neusoft.elmboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neusoft.elmboot.po.Food;
import com.neusoft.elmboot.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	@Autowired
	private FoodService foodService;

	@GetMapping("/listByBusinessId")
	public List<Food> listFoodByBusinessId(Integer businessId) throws Exception {
		return foodService.listFoodByBusinessId(businessId);
	}
}
