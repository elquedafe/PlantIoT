package es.upm.dte.iot.hwplatform;

import es.upm.dte.iot.Sensor;
import es.upm.dte.iot.infomodel.*;
import upm_grove.GroveRotary;

// Humidity 5%-99%
// Rotaty 0-300
public class HumiditySensor extends Sensor {
	
	private GroveRotary humSensor;

	public SensorMeasurement monitor() {
		float angle = humSensor.abs_deg();
		return new SensorMeasurement(getId(), getObservationProperty(), (angle * 94 / 300)+5.0);
	}

	/**
	 * 
	 * @param id
	 * @param adc 
	 * @param observerProperty
	 */
	public HumiditySensor(String id, long analogPort) {
		super(id,"dbl");
		humSensor = new GroveRotary(analogPort);
	}
	

}