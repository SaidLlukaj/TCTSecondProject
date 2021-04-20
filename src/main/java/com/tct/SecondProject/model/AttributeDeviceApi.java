package com.tct.SecondProject.model;

public class AttributeDeviceApi {
    private Integer id;
    private String name;
    private Integer minValue;
    private Integer maxValue;
    private Integer currentValue;
    private Integer deviceId;

    public AttributeDeviceApi(){

    }
    public AttributeDeviceApi(DeviceAttribute deviceAttribute){
        this.id=deviceAttribute.getId();
        this.name=deviceAttribute.getName();
        this.minValue=deviceAttribute.getMinValue();
        this.maxValue=deviceAttribute.getMaxValue();
        this.currentValue=deviceAttribute.getCurrentValue();
        this.deviceId=deviceAttribute.getDevice().getId();



    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxvalue) {
        this.maxValue = maxvalue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
}
