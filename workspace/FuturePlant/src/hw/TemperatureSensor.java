package hw;

import java.io.IOException;

import es.upm.dte.iot.Sensor;
import es.upm.dte.iot.infomodel.SensorMeasurement;

public class TemperatureSensor extends Sensor{
	OneWire oneWire;
	public TemperatureSensor(String id) {
		super(id, "int");
		this.oneWire = new OneWire();
	}

	@Override
	public SensorMeasurement monitor() {
		try {
			return new SensorMeasurement(getId(), getObservationProperty(), oneWire.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public double read(){
		try {
			return oneWire.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
