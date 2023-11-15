package com.neusoft.elmboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.BusinessMapper;
import com.neusoft.elmboot.po.Business;
import com.neusoft.elmboot.po.BusinessListConstraints;
import com.neusoft.elmboot.service.BusinessService;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessMapper businessMapper;

	@Cacheable(value = "Business")
	@Override
	public Business getBusinessById(Integer businessId) {
		return businessMapper.getBusinessById(businessId);
	}

	@Caching(evict = { @CacheEvict(value = "Business", allEntries = true) }, put = {
			@CachePut(value = "BusinessList", key = "#businessId") })
	@Override
	public Integer updateBusinessHot(Integer businessId, Integer hot) {
		return businessMapper.updateBusinessHot(businessId, hot);
	}

	@Cacheable(value = "BusinessList", key = "#constraint.hashCode()")
	@Override
	public List<Business> listBusiness(BusinessListConstraints constraint) {
		if (constraint.getBusinessName() != null) {
			return businessMapper.listBusinessByName(constraint.getBusinessName());
		} else if (constraint.getBusinessAddress() != null) {
			return businessMapper.listBusinessByAddress(constraint.getBusinessAddress());
		} else if (constraint.getOrderTypeId() != null) {
			return businessMapper.listBusinessByOrderTypeId(constraint.getOrderTypeId());
		} else {
			throw new IllegalArgumentException("Invalid operation type");
		}
	}
}
