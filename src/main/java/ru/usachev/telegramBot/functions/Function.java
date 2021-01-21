package ru.usachev.telegramBot.functions;

import org.telegram.telegrambots.api.objects.Message;

public interface Function {
    public String execute(Message message);
}
