package com.neusoft.elmboot.po;
import lombok.Data;

@Data
public class BusinessListConstraints {
    private Integer orderTypeId;
    private String businessName;
    private String businessAddress;

    public Integer getOrderTypeId() {
        return orderTypeId;
    }
    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
    public String getBusinessName() {
        return businessName;
    }
     public void setBusinessName(String businessName){
        this.businessName = businessName;
    }
    public String getBusinessAddress() {
        return businessAddress;
    }
     public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }
}