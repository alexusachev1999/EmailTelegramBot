package ru.usachev.telegramBot.functions;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class StartBot implements Function{
    @Override
    public String execute(Message message) {
        return "Привет, "+message.getFrom().getFirstName()+"! Что будем делать?)"+"\n"
                +"Вот мои команды:"+"\n\t"+"/find         - Найти email сотрудника по имени"
                +"\n\t"+"/create       - Добавить нового сотрудника в базу"
                ;
    }
}
