package es.upm.dte.iot.hwplatform;

import es.upm.dte.iot.*;
import upm_i2clcd.Jhd1313m1;

public class Display extends Actuator {
	private final short RED_BY_DEFAULT = 0;
	private final short GREEN_BY_DEFAULT = 0;
	private final short BLUE_BY_DEFAULT = 255;
	
	private final short RED_BOLD = 255;
	private final short GREEN_BOLD = 64;
	private final short BLUE_BOLD = 0;

	private Jhd1313m1 lcd = null;
	
	private synchronized void lcdUpdate (String message1, String message2) {
		lcd.clear();
		// display a message on the first row of the LCD
		lcd.setCursor(0, 0);
		lcd.write(message1);
		lcd.setCursor(1, 0);
		lcd.write(message2);
		
		// apply the calculated result
		lcd.setColor(RED_BOLD, GREEN_BOLD, BLUE_BOLD);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// apply the default values (red = 0, green = 0, blue = 255)
		lcd.setColor(RED_BY_DEFAULT, GREEN_BY_DEFAULT, BLUE_BY_DEFAULT);
	}
	
	public Display(String id) {
		super(id,ActuatorType.LCDRGBBackLight);
		
		// LCD connected to the default I2C bus
		lcd = new Jhd1313m1(0);

		// display an initial message on the LCD
		lcd.setCursor(0, 0);
		lcd.write("ID: "+id);
		
		// apply the default values (red = 0, green = 0, blue = 255)
		lcd.setColor(RED_BY_DEFAULT, GREEN_BY_DEFAULT, BLUE_BY_DEFAULT);
	}

	/**
	 * 
	 * @param action
	 */
	public void act(Object action) {
		if ( action instanceof LCDActionDescription ) {
			LCDActionDescription aux = (LCDActionDescription)action;
			lcdUpdate(aux.getL1(), aux.getL2());
		}
		else
			throw new IllegalArgumentException("Action is not an instance of "+LCDActionDescription.class.getName()+".");
	}


}