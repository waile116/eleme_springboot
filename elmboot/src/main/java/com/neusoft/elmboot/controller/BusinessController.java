package com.neusoft.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neusoft.elmboot.po.Business;
import com.neusoft.elmboot.po.BusinessListConstraints;
import com.neusoft.elmboot.service.BusinessService;

@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private BusinessService businessService;

	@GetMapping("/listByOrderTypeId")
	public List<Business> listBusinessByOrderTypeId(Business business) throws Exception {
		BusinessListConstraints constraint = new BusinessListConstraints();
		constraint.setOrderTypeId(business.getOrderTypeId());
		return businessService.listBusiness(constraint);
	}

	@GetMapping("/getById")
	public Business getBusinessById(Integer businessId) throws Exception {
		return businessService.getBusinessById(businessId);
	}

	@GetMapping("/listByName")
	public List<Business> listBusinessByName(String businessName) throws Exception {
		BusinessListConstraints constraint = new BusinessListConstraints();
		constraint.setBusinessName(businessName);
		return businessService.listBusiness(constraint);
	}

	@GetMapping("/listByAddress")
	public List<Business> listBusinessByAddress(String businessAddress) {
		BusinessListConstraints constraint = new BusinessListConstraints();
		constraint.setBusinessAddress(businessAddress);
		return businessService.listBusiness(constraint);
	}

	@PutMapping("/updateHot")
	public Integer updateBusinessHot(Integer businessId) {
		Integer hot = businessService.getBusinessById(businessId).getHot();
		hot++;
		return businessService.updateBusinessHot(businessId, hot);
	}

	@GetMapping("/listByOrderTypeIdByHot")
	public List<Business> listBusinessByOrderTypeIdByHot(Integer orderTypeId) {
		BusinessListConstraints constraint = new BusinessListConstraints();
		constraint.setOrderTypeId(orderTypeId);
		return businessService.listBusiness(constraint);
	}

}
