package com.gpsProject.gpsProject;

import com.gpsProject.gpsProject.model.Device;
import com.gpsProject.gpsProject.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GpsProjectApplicationTests {

	@Autowired
	DeviceService deviceService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveDeviceTest(){
		Device d = Device.builder().deviceId("236432").latitiude("52.229676").longitude("21.01222").build();
		deviceService.saveDevice(d);
		List<Device> devices = deviceService.findAllDevices();
		assertEquals(1, devices.size());
	}
}
