package com.gpsProject.gpsProject.controller;

import com.gpsProject.gpsProject.model.Device;
import com.gpsProject.gpsProject.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping
public class DeviceController {

    public static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public ResponseEntity<List<Device>> listAllDevices() {
        List<Device> devices = deviceService.findAllDevices();
        if (devices.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
    }

    @RequestMapping(value = "/devices", method = RequestMethod.POST)
    public ResponseEntity<String> createDevice(@RequestBody Device device, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Device : {}", device);
        deviceService.saveDevice(device);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/devices/{id}").buildAndExpand(device.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
