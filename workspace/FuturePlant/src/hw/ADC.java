package hw;

import java.io.IOException;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;

public class ADC {
	private SpiDevice spi;
	
	public ADC(SpiChannel cs, int speed){
		try {
			this.spi = SpiFactory.getInstance(cs, speed);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public int read(int channel) throws IOException{
		byte data[] = new byte[]{
				(byte) 0b00000001,
				(byte) (0b10000000 | (((channel & 7) << 4))),
				(byte) 0b00000000
		};
		byte[] result = spi.write(data);
		int value = (result[1]<<8) & 0b1100000000;
		value |= (result[2] & 0xff);
		
		return value;
	}

}
