package plant;

import es.upm.dte.iot.*;
import es.upm.dte.iot.infomodel.*;

public class PlantResource extends Thing {

	private PlantRepresentation plantRepresentation;
	private IRepresentationGenerator<PlantRepresentation> representationGenerator;

	public PlantResource(String situation) {
		super(situation);
		plantRepresentation = new PlantRepresentation();
		representationGenerator = ThingsSequenceRepresentationFactory.getInstance("JSON");
		if ( representationGenerator == null )
			throw new IllegalStateException("Not representation generator available.");
	}

	@Override
	public String getRepresentation() {
		Observation obs = observe();
		plantRepresentation.setPlantObservation(obs);
		return representationGenerator.genRepresentation(plantRepresentation);
	}
	@Override
	public void setFromRepresentation(String representation) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void attach(ITag tag) {
		super.attach(tag);
		plantRepresentation.setPlantId(tag.getIdentification());
	}

	@Override
	public void operate() {
		throw new UnsupportedOperationException();
	}

}