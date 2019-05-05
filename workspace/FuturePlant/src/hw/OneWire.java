package hw;

import java.io.IOException;
import java.util.List;

import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import com.pi4j.component.temperature.TemperatureSensor;

public class OneWire {
	private List<W1Device> w1Devices;
	private W1Master master;
	
	public OneWire(){
		master = new W1Master();
		w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);
	}
	public double read() throws IOException{
		double temp = -1.0;
		for (W1Device device : w1Devices) {
			temp = ((TemperatureSensor) device).getTemperature();
		    System.out.println("Temperature: " + temp + " - id: "+ device.getId());
		}
		return temp;
	}

}
