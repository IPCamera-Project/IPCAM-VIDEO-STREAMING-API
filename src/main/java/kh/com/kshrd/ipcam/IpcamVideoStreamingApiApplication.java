package kh.com.kshrd.ipcam;

import kh.com.kshrd.ipcam.controller.camera.IPCamControlController;
import kh.com.kshrd.ipcam.entity.camera.Command;
import kh.com.kshrd.ipcam.service.impl.CommandServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@ComponentScan(basePackageClasses = IPCamControlController.class)
//@ComponentScan
public class IpcamVideoStreamingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpcamVideoStreamingApiApplication.class, args);
	}
}
