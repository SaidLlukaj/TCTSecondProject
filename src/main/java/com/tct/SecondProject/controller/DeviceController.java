package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.Device;
import com.tct.SecondProject.model.DeviceApiModel;
import com.tct.SecondProject.model.FindAll;
import com.tct.SecondProject.model.Room;
import com.tct.SecondProject.repository.DeviceRepository;
import com.tct.SecondProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/devices")
    public FindAll<DeviceApiModel> getAll() {
        FindAll<DeviceApiModel> allDevices = new FindAll<>();

        List<Device> devices = deviceRepository.findAll();
        allDevices.setItems(devices);
        return allDevices;
    }
    @PostMapping("/devices")
    public void createDevice(@RequestBody DeviceApiModel deviceApiModel) {
        Room room =roomRepository.getOne(deviceApiModel.getRoomId());
        Device device=new Device();
        device.setName(deviceApiModel.getName());
        device.setIsOn(deviceApiModel.getIsOn());
        device.setRoom(room);
        deviceRepository.save(deviceApiModel);
    }

}