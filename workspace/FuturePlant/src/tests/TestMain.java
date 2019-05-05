package tests;

import com.raspoid.PWMPin;
import com.raspoid.additionalcomponents.PassiveBuzzer;
import com.raspoid.additionalcomponents.notes.BaseNote;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int timePerNote = 200; // ms
        PassiveBuzzer buzzer;
        buzzer = new PassiveBuzzer(PWMPin.PWM1);
        for(int times = 0; times < 3; times++)
        	playElisa(buzzer, 4, timePerNote);

	}
	
	private static void playElisa(PassiveBuzzer buzzer, int i, int timePerNote){
		//for(int j = 0; j < 3; j++){
			buzzer.playNote(BaseNote.MI_0, i, timePerNote);
			buzzer.playNote(BaseNote.RE_0, i, timePerNote);
			buzzer.playNote(BaseNote.MI_0, i, timePerNote);
			buzzer.playNote(BaseNote.RE_0, i, timePerNote);
			buzzer.playNote(BaseNote.MI_0, i, timePerNote);
			buzzer.playNote(BaseNote.SI_0, i-1, timePerNote);
			buzzer.playNote(BaseNote.RE_0, i, timePerNote);
			buzzer.playNote(BaseNote.DO_0, i, timePerNote);
			buzzer.playNote(BaseNote.LA_0, i-1, timePerNote*3);
			buzzer.playNote(BaseNote.DO_0, i-1, timePerNote);
			buzzer.playNote(BaseNote.MI_0, i-1, timePerNote);
			buzzer.playNote(BaseNote.LA_0, i-1, timePerNote);
			buzzer.playNote(BaseNote.SI_0, i-1, timePerNote*3);
			buzzer.playNote(BaseNote.MI_0, i-1, timePerNote);
			buzzer.playNote(BaseNote.SOL_0, i-1, timePerNote);
			buzzer.playNote(BaseNote.SI_0, i-1, timePerNote);
			buzzer.playNote(BaseNote.DO_0, i, timePerNote*3);
			buzzer.playNote(BaseNote.MI_0, i-1, timePerNote);
		//}
		buzzer.playNote(BaseNote.MI_0, i, timePerNote);
		buzzer.playNote(BaseNote.RE_0, i, timePerNote);
		buzzer.playNote(BaseNote.MI_0, i, timePerNote);
		buzzer.playNote(BaseNote.RE_0, i, timePerNote);
		buzzer.playNote(BaseNote.MI_0, i, timePerNote);
		buzzer.playNote(BaseNote.SI_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.RE_0, i, timePerNote);
		buzzer.playNote(BaseNote.DO_0, i, timePerNote);
		buzzer.playNote(BaseNote.LA_0, i-1, timePerNote*3);
		buzzer.playNote(BaseNote.DO_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.MI_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.LA_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.SI_0, i-1, timePerNote*3);
		buzzer.playNote(BaseNote.MI_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.DO_0, i, timePerNote);
		buzzer.playNote(BaseNote.SI_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.LA_0, i-1, timePerNote*3);
		buzzer.playNote(BaseNote.SI_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.DO_0, i, timePerNote);
		buzzer.playNote(BaseNote.RE_0, i, timePerNote);
		buzzer.playNote(BaseNote.MI_0, i, timePerNote*3);
		buzzer.playNote(BaseNote.SOL_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.FA_0, i, timePerNote);
		buzzer.playNote(BaseNote.MI_0, i, timePerNote);
		buzzer.playNote(BaseNote.RE_0, i, timePerNote*3);
		buzzer.playNote(BaseNote.SOL_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.MI_0, i, timePerNote);
		buzzer.playNote(BaseNote.RE_0, i, timePerNote);
		buzzer.playNote(BaseNote.DO_0, i, timePerNote*3);
		buzzer.playNote(BaseNote.MI_0, i-1, timePerNote);
		buzzer.playNote(BaseNote.RE_0, i, timePerNote);
		buzzer.playNote(BaseNote.DO_0, i, timePerNote);
		buzzer.playNote(BaseNote.SI_0, i-1, timePerNote*4);
		
	}

}
