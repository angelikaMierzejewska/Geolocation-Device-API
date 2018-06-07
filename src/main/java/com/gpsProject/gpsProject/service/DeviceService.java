package com.gpsProject.gpsProject.service;

import com.gpsProject.gpsProject.model.Device;
import java.util.List;

public interface DeviceService {

    List<Device> findAllDevices();
    void saveDevice(Device device);
}
