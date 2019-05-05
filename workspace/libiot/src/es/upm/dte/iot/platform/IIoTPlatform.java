package es.upm.dte.iot.platform;

public interface IIoTPlatform {

	/**
	 * 
	 * @param representation
	 * @throws IoTPlatformException 
	 */
	void publishThingRepresentation(String representation1, String representation2) throws IoTPlatformException;

	String getNextAction() throws IoTPlatformException;

}