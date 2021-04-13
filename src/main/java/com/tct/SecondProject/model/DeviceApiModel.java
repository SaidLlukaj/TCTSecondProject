package com.tct.SecondProject.model;

public class DeviceApiModel {

    private Integer id;
    private String name;
    private Boolean isOn;
    private Integer roomId;
    public DeviceApiModel
    public DeviceApiModel(Device device){

        this.id=device.getId();
        this.id=device.getId();
        this.id=device.getId();
        this.id=device.getId();
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

    public Boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(Boolean on) {
        isOn = on;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
