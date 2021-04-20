package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.*;
import com.tct.SecondProject.repository.DeviceAttributeRepository;
import com.tct.SecondProject.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Attribute;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AttributeController {
    @Autowired
    private DeviceAttributeRepository deviceAttributeRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/devices/{deviceId}/attributes")
    public FindAll<AttributeDeviceApi> getDeviceAttributes(@PathVariable Integer deviceId) {
        Optional<Device> optional = deviceRepository.findById(deviceId);
        Device device = optional.get();
        List<DeviceAttribute> attributes = deviceAttributeRepository.findByDevice(device);
        List<AttributeDeviceApi> models = attributes.stream()
                .map(AttributeDeviceApi::new)
                .collect(Collectors.toList());


        FindAll<AttributeDeviceApi> all = new FindAll<>();
        all.setItems(models);
        return all;
    }

    @PostMapping("/devices/{deviceId}/attributes")
    public void creaateAttribute(@PathVariable Integer deviceId, @RequestBody AttributeDeviceApi model) {
        Device device = deviceRepository.getOne(deviceId);
        DeviceAttribute deviceAttribute = new DeviceAttribute();
        deviceAttribute.setCurrentValue(model.getCurrentValue());

        deviceAttribute.setName(model.getName());
        deviceAttribute.setMaxValue(model.getMaxValue());
        deviceAttribute.setMinValue(model.getMinValue());
        deviceAttribute.setDevice(device);
        deviceAttributeRepository.save(deviceAttribute);


    }

    @PutMapping("/devices/{deviceid}/attributes/{attributeId}")
    public void updateAttribute(@PathVariable Integer deviceid,
                                @RequestBody AttributeDeviceApi model,
                                @PathVariable Integer attributeId) {
        DeviceAttribute deviceAttribute = deviceAttributeRepository.getOne(attributeId);
        deviceAttribute.setName(model.getName());
        deviceAttribute.setMinValue(model.getMinValue());
        deviceAttribute.setMaxValue(model.getMaxValue());
        deviceAttribute.setCurrentValue(model.getCurrentValue());


        deviceAttributeRepository.save(deviceAttribute);

    }

    @DeleteMapping("/devices/{deviceId}/attributes/attributeId")
    public void deleteDevice(@PathVariable Integer id,
                             @RequestBody DeviceApiModel model,
                             @PathVariable Integer attributeId) {

        deviceAttributeRepository.deleteById(attributeId);
    }
}


