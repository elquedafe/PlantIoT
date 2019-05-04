package es.upm.dte.iot.hwplatform;

import es.upm.dte.iot.Sensor;
import es.upm.dte.iot.infomodel.*;
import upm_grove.GroveLight;

public class LuminositySensor extends Sensor {
	
	GroveLight light;

	public SensorMeasurement monitor() {
		return new SensorMeasurement(getId(), getObservationProperty(), light.value());
	}

	/**
	 * 
	 * @param id
	 * @param observerProperty
	 */
	public LuminositySensor(String id, long analogPort) {
		super(id,"int");
		light = new GroveLight(analogPort);
	}

}