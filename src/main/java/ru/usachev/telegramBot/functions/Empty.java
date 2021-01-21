package ru.usachev.telegramBot.functions;

import org.telegram.telegrambots.api.objects.Message;

public class Empty implements Function{
    @Override
    public String execute(Message message) {
        return "Не существует такой команды или пользователя!";
    }
}
