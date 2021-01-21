package ru.usachev.telegramBot.functions;

import org.telegram.telegrambots.api.objects.Message;
import ru.usachev.telegramBot.dao.UserDAO;

public class FindUser implements Function{
    UserDAO dao = new UserDAO();
    @Override
    public String execute(Message message) {
        return message.getFrom().getFirstName() + ", введите имя интересующего вас пользователя (например, Денис)," +
                " чтобы получить его email.";
    }

    public String findUsersEmail(Message message){
        return "Email пользователя "+message.getText()+" "+dao.getUserEmailByName(message.getText());
    }
}
