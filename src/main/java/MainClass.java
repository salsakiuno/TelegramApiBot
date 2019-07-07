import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {

//            HttpClient newHttpClient = new HttpClient();

//            String hiredTaxi =  newHttpClient.PostHiredTaxi();
 //           System.out.println(hiredTaxi);

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new AvailableBotClass() );
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }





    }
}
