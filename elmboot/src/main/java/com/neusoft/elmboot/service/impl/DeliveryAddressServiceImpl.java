package com.neusoft.elmboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.DeliveryAddressMapper;
import com.neusoft.elmboot.po.DeliveryAddress;
import com.neusoft.elmboot.service.DeliveryAddressService;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
	@Autowired
	private DeliveryAddressMapper deliveryAddressMapper;

	@Override
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
		return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
	}

	@Override
	public DeliveryAddress getDeliveryAddressById(Integer daId) {
		return deliveryAddressMapper.getDeliveryAddressById(daId);
	}

	@Override
	public int removeDeliveryAddress(Integer daId) {
		return deliveryAddressMapper.removeDeliveryAddress(daId);
	}

	@Override
	public int deliveryAddressOperation(DeliveryAddress deliveryAddress, String operation) {
		switch (operation) {
			case "save":
				return deliveryAddressMapper.saveDeliveryAddress(deliveryAddress);
			case "update":
				return deliveryAddressMapper.updateDeliveryAddress(deliveryAddress);
			default:
				throw new IllegalArgumentException("Invalid delivery address operation type: " + operation);
		}
	}
}
