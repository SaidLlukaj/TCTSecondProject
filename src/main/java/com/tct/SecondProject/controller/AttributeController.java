package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.Device;
import com.tct.SecondProject.model.DeviceAttribute;
import com.tct.SecondProject.model.FindAll;
import com.tct.SecondProject.model.Room;
import com.tct.SecondProject.repository.DeviceAttributeRepository;
import com.tct.SecondProject.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Attribute;
import java.util.List;

@RestController
public class AttributeController {
    @Autowired
    private DeviceAttributeRepository deviceAttributeRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @GetMapping ("/devices/{deviceId}/attributes")
  public  FindAll<DeviceAttribute> getDeviceAttributes (@PathVariable Integer deviceId){

        Device device=deviceRepository.getOne(deviceId);
        List<DeviceAttribute> attributes=deviceAttributeRepository.findByDevice(device);
        FindAll<DeviceAttribute> all = new FindAll<>();
        all.setItems();



  }



}
