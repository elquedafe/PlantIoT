package bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotManager{

	public void run() {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		Bot bot = new Bot();
		try{
			telegramBotsApi.registerBot(bot);
		}catch(TelegramApiException e){
			e.printStackTrace();
			e.getMessage();
		}
		System.out.println("***Bot for \"Future Plant Iot\" telegram group created***");
		
	}

}
