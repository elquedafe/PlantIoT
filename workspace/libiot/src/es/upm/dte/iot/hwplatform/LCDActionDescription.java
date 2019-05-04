package es.upm.dte.iot.hwplatform;

import java.io.UnsupportedEncodingException;

public class LCDActionDescription {

	private String l1;
	private String l2;
	public String getL1() {
		return l1;
	}
	public void setL1(String l1) {
		byte []aux = l1.getBytes();
		try {
			this.l1 = new String( aux, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}
	public String getL2() {
		return l2;
	}
	public void setL2(String l2) {
		byte []aux = l2.getBytes();
		try {
			this.l2 = new String( aux, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}
	
	public LCDActionDescription(String l1, String l2) {
		super();
		byte []aux = l1.getBytes();
		try {
			this.l1 = new String( aux, "UTF-8");
			aux = l2.getBytes();
			this.l2 = new String( aux, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

}