package ru.usachev.telegramBot;

import ru.usachev.telegramBot.dao.UserDAO;

public class Test {
    public static void main(String[] args) {


        UserDAO dao = new UserDAO();
        System.out.println(dao.show("Mike"));
    }
}
