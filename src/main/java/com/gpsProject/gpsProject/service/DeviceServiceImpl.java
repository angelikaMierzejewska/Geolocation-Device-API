package com.gpsProject.gpsProject.service;

import com.gpsProject.gpsProject.model.Device;
import com.gpsProject.gpsProject.repository.DeviceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public void saveDevice(Device device){
        deviceRepository.save(device);
    }

    public List<Device> findAllDevices(){
        List<Device> listDevices = deviceRepository.findAll();
        return listDevices ;
    }
}
