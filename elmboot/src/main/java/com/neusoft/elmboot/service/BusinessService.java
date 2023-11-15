package com.neusoft.elmboot.service;

import com.neusoft.elmboot.po.Business;
import com.neusoft.elmboot.po.BusinessListConstraints;

import java.util.List;

public interface BusinessService {

    public Business getBusinessById(Integer businessId);

    public Integer updateBusinessHot(Integer businessId, Integer hot);

    public List<Business> listBusiness(BusinessListConstraints constraint);
}
