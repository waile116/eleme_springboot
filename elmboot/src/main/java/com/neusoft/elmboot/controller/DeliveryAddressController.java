package com.neusoft.elmboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neusoft.elmboot.po.DeliveryAddress;
import com.neusoft.elmboot.service.DeliveryAddressService;

@RestController
@RequestMapping("/deliveryAddress")
public class DeliveryAddressController {
	@Autowired
	private DeliveryAddressService deliveryAddressService;

	@GetMapping("/listByUserId")
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) throws Exception {
		return deliveryAddressService.listDeliveryAddressByUserId(userId);
	}

	@PostMapping("/save")
	public int saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
		return deliveryAddressService.deliveryAddressOperation(deliveryAddress, "save");
	}

	@GetMapping("/getById")
	public DeliveryAddress getDeliveryAddressById(Integer daId) throws Exception {
		return deliveryAddressService.getDeliveryAddressById(daId);
	}

	@PutMapping("/update")
	public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
		return deliveryAddressService.deliveryAddressOperation(deliveryAddress, "update");
	}

	@DeleteMapping("/remove")
	public int removeDeliveryAddress(Integer daId) throws Exception {
		return deliveryAddressService.removeDeliveryAddress(daId);
	}
}
