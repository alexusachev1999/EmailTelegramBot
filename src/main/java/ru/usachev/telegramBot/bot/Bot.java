package ru.usachev.telegramBot.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.usachev.telegramBot.dao.UserDAO;
import ru.usachev.telegramBot.functions.CreateUser;
import ru.usachev.telegramBot.functions.Function;
import ru.usachev.telegramBot.functions.Functions;
import ru.usachev.telegramBot.models.User;


public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "ausachev_bot";
    }
    @Override
    public String getBotToken() {
        return "1546816033:AAEXzIJwNDniQ-d4_Ik36qgAb8L451_k_to";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        UserDAO dao = new UserDAO();
        CreateUser createUser = new CreateUser();
        if (message != null && message.hasText()) {

            if (message.getText().matches("[a-zA-Zа-яА-Я]+")){
                sendMessage(message, "Email пользователя "+message.getText()+" "+
                        dao.getUserEmailByName(message.getText()));

            } else if (message.getText().contains(" ")&&message.getText().contains("@") ){
                User user = createUser.createNewUser(message);
                sendMessage(message, "Новый пользователь - "+user.getName()+" добавлен в базу");

            }

            else {
                Function function = Functions.getFunction(message.getText());
                sendMessage(message, function.execute(message));
            }
        }
    }

    public void sendMessage(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

