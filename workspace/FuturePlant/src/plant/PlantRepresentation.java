package plant;


import es.upm.dte.iot.infomodel.*;

public class PlantRepresentation {

	private ThingObservation planta;

	public void setPlantObservation(Observation obs) {
		if ( planta == null )
			throw new IllegalStateException("Planta representation has not been instantiated yet.");
		planta.setObs(obs);
	}

	public void setPlantId(String id) {
		planta = new ThingObservation(id);
	}

}