package plant;

import hw.ADC;
import hw.FlameSensor;
import hw.HumidityGroundSensor;
import hw.LuminositySensor;
import hw.TemperatureSensor;
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
	
	private PlantResource plantaRes1;
	private PlantResource plantaRes2;
	private IIoTPlatform plataforma;
	private final int ADC_SPI_CH_SPEED = 1350000;
	private final int ADC_FLAME = 0;
	private final int ADC_HUM = 1;
	private final int ADC_WATER = 2;
	private final int ADC_LUMINOSITY = 3;
	private final String WRITER_KEY = "HSHMWTHNM8PFHR5W";
	
	public MeasuresUploadTask() {
//		HumiditySensor hum = new HumiditySensor("hum", 0);
//		LuminositySensor lum = new LuminositySensor("lum", 1);
//		TemperatureSensor temp = new TemperatureSensor("temp", 2);
		//Analog to Digital Converter
		ADC adc = new ADC(SpiChannel.CS0, ADC_SPI_CH_SPEED);
		
		//Sensors
		FlameSensor flame = new FlameSensor("flame", ADC_FLAME, adc);
		HumidityGroundSensor humidity = new HumidityGroundSensor("hum", ADC_HUM, adc);
		WaterLevelSensor waterLevel = new WaterLevelSensor("level", ADC_WATER, adc);
		LuminositySensor luminosity = new LuminositySensor("lum", ADC_LUMINOSITY, adc);
		TemperatureSensor temperature = new TemperatureSensor("temp");
		
		
		Tag tag = new Tag("743");
		Properties properties = new Properties();
		properties.setProperty("WRITER_KEY", WRITER_KEY);
		
		//Plant
		plantaRes1 = new PlantResource("40.389747 -3.629441");
		
		plantaRes1.attach(flame);
		plantaRes1.attach(luminosity);
		plantaRes1.attach(waterLevel);
		plantaRes1.attach(tag);
		
		plantaRes2 = new PlantResource("40.389747 -3.629441");
		plantaRes2.attach(temperature);
		plantaRes2.attach(humidity);
		plantaRes2.attach(tag);
		
		plataforma = IoTPlatformFactory.getInstance("ThingSpeak", properties);
	}

	@Override
	public void run() {
		String aux1;
		String aux2;
		try {
			aux1 = plantaRes1.getRepresentation();
			aux2 = plantaRes2.getRepresentation();
			System.out.println( aux1 );
			System.out.println( aux2 );
			plataforma.publishThingRepresentation(aux1, aux2);
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
		System.out.println("***Plant Manager running***");
	}
}