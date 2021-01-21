package ru.usachev.telegramBot.functions;

import org.telegram.telegrambots.api.objects.Message;
import ru.usachev.telegramBot.dao.UserDAO;
import ru.usachev.telegramBot.models.User;

import java.util.ArrayList;
import java.util.List;

public class CreateUser implements Function{
    UserDAO dao = new UserDAO();
    @Override
    public String execute(Message message) {
        return message.getFrom().getFirstName() + ", введите имя, возраст, email через пробел интересующего вас пользователя (например, Денис 23 den@mail.ru)," +
                " чтобы создать нового пользователя";
    }

    public User createNewUser(Message message){
        String[] words = message.getText().split(" ");
        List<String> strings = new ArrayList<>();
        for (String str : words){
            strings.add(str);
        }
        User user = new User();
        user.setName(strings.get(0));
        user.setAge(Integer.parseInt(strings.get(1)));
        user.setEmail(strings.get(2));

        dao.save(user);

        return user;
    }
}
