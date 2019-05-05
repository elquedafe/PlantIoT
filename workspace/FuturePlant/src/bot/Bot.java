package bot;

import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "FuturePlantBot";
	}

	@Override
	public void onUpdateReceived(Update update) {
		
	}

	@Override
	public void onUpdatesReceived(List<Update> updates) {
		Update update = updates.get(0);
		Message message = update.getMessage();
		SendMessage outMessage = null;
		long chatId = update.getMessage().getChatId();
		print(message.getText().toString());
		if(message != null && message.hasText()){
			switch(message.getText().toString()){
				case "/on_music": 
				case "/on_music@FuturePlantBot":
					outMessage = new SendMessage().setChatId(chatId).setText("Playing music");
					try {
						execute(outMessage);
					} catch (TelegramApiException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "/off_music": 
				case "/off_music@FuturePlantBot":
					outMessage = new SendMessage().setChatId(chatId).setText("Turning off music");
					try {
						execute(outMessage);
					} catch (TelegramApiException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "/water_plant":
				case "/water_plant@FuturePlantBot":
					outMessage = new SendMessage().setChatId(chatId).setText("Watering plant");
					try {
						execute(outMessage);
					} catch (TelegramApiException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
			}
		}
		
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "869726392:AAGhXTcDXjnjaE9bP0ioX2jLLt3OlVgpklk";
	}
	
	private void print(String msg){
		System.out.println("Bot_Thread: " + msg);
	}

}
