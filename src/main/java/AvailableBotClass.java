import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Arrays;

public class AvailableBotClass extends TelegramLongPollingBot {
    UserClass user;

    public AvailableBotClass() {
        UserClass newUser = new UserClass();
        user = newUser;
    }

    public void onUpdateReceived(Update update) {
        TaxisMethods taxisBarcelona = new TaxisMethods();
        String command = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage();

        if (update.hasMessage() && update.getMessage().hasText()){

            if (command.equals("/start")){
                message.setChatId(chatId).setText("Please write your city");

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }else if (update.getMessage().getText().charAt(0) != '/'){
                String newCity = command.substring(0, 1).toUpperCase()+ command.substring(1);

                String cities[] = {"Madrid", "Barcelona", "Valencia", "Bilbao"};
                if (Arrays.asList(cities).contains(newCity)){
                    message.setChatId(chatId).setText("Your city is "+ newCity);

                }else {message.setChatId(chatId).setText(newCity + " is not a valid city. Please enter a valid city");}

                user.setCity(newCity);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }else if (command.equals("/gettaxibarcelona")) {
                try {
                    message.setChatId(chatId).setText("The number os taxis near you is: "+taxisBarcelona.numOfTaxis(user.getCity()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (command.equals("/hiretaxi")) {

                try {
                    message.setChatId(chatId).setText("Congratulations, your taxi is now " + taxisBarcelona.hireTaxi() + ", will be there soon");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    public String getBotUsername() {
        return "Availablebot";
    }

    public String getBotToken() {
        return "746948780:AAFEaRgKQXdaEjajoh62kjuXRluLTHbAfSw";
    }
}

