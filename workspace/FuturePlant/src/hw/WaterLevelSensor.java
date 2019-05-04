package hw;

import java.io.IOException;

import es.upm.dte.iot.Sensor;
import es.upm.dte.iot.infomodel.SensorMeasurement;

public class WaterLevelSensor extends Sensor {
	private ADC adc;
	private int adcChannel;

	public WaterLevelSensor(String id, int adcChannel, ADC adc) {
		super(id, "int");
		this.adcChannel = adcChannel;
		this.adc = adc;
	}

	@Override
	public SensorMeasurement monitor() {
		try {
			return new SensorMeasurement(getId(), getObservationProperty(), (double)adc.read(adcChannel));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
