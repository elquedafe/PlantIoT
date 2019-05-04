package es.upm.dte.iot.hwplatform;

import es.upm.dte.iot.Sensor;
import es.upm.dte.iot.infomodel.*;
import upm_grove.GroveTemp;

public class TemperatureSensor extends Sensor {
	
	private GroveTemp temp;

	public SensorMeasurement monitor() {
		return new SensorMeasurement(getId(), getObservationProperty(), temp.value());
	}

	/**
	 * 
	 * @param id
	 * @param observerProperty
	 */
	public TemperatureSensor(String id, long analogPort) {
		super(id,"int");
		temp = new GroveTemp(analogPort);
	}

}