package hw;

import java.io.IOException;

import es.upm.dte.iot.Sensor;
import es.upm.dte.iot.infomodel.SensorMeasurement;

public class FlameSensor extends Sensor{
	private ADC adc;
	private int adcChannel;

	public SensorMeasurement monitor(){
		try {
			return new SensorMeasurement(getId(), getObservationProperty(), (double)adc.read(adcChannel));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param observerProperty
	 * @param adc
	 */
	public FlameSensor(String id, int adcChannel, ADC adc) {
		super(id, "int");
		this.adcChannel = adcChannel;
		this.adc = adc;
	}


}
