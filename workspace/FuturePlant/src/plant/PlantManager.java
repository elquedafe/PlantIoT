package plant;

import hw.ADC;
import hw.FlameSensor;
import hw.HumidityGroundSensor;
import hw.WaterLevelSensor;

import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import com.pi4j.io.spi.SpiChannel;

import es.upm.dte.iot.Tag;
//import es.upm.dte.iot.hwplatform.LuminositySensor;
//import es.upm.dte.iot.hwplatform.TemperatureSensor;
import es.upm.dte.iot.platform.IIoTPlatform;
import es.upm.dte.iot.platform.IoTPlatformFactory;

class MeasuresUploadTask extends TimerTask{
	
	private PlantResource planta;
	private IIoTPlatform plataforma;
	private final int CH_SPEED = 1350000;
	
	public MeasuresUploadTask() {
//		HumiditySensor hum = new HumiditySensor("hum", 0);
//		LuminositySensor lum = new LuminositySensor("lum", 1);
//		TemperatureSensor temp = new TemperatureSensor("temp", 2);
		//Analog to Digital Converter
		ADC adc = new ADC(SpiChannel.CS0, CH_SPEED);
		
		//Sensors
		FlameSensor flame = new FlameSensor("flame", 0, adc);
		HumidityGroundSensor humidity = new HumidityGroundSensor("hum", 1, adc);
		WaterLevelSensor waterLevel = new WaterLevelSensor("level", 2, adc);
		
		Tag tag = new Tag("743");
		Properties properties = new Properties();
		properties.setProperty("WRITER_KEY", "HSHMWTHNM8PFHR5W");
		
		planta = new PlantResource("40.389747 -3.629441");
		
		planta.attach(flame);
		planta.attach(humidity);
		planta.attach(waterLevel);
		planta.attach(tag);
		
		plataforma = IoTPlatformFactory.getInstance("ThingSpeak", properties);
	}

	@Override
	public void run() {
		String aux;
		try {
			aux = planta.getRepresentation();
			System.out.println( aux );
			plataforma.publishThingRepresentation(aux);
			System.out.println("Got it!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

public class PlantManager {
	private final static int PERIOD = 20000;

	public static void run() {

		
		Timer scheduler = new Timer();
		
		scheduler.scheduleAtFixedRate(new MeasuresUploadTask(), 0, PERIOD);
	}
}