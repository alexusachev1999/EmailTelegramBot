package ru.usachev.telegramBot.functions;

import java.util.HashMap;
import java.util.Map;

public class Functions {
    private static Map <String, Function> functionMap = new HashMap<>();
    private static StartBot startBot;
    private static FindUser findUser;
    private static CreateUser createUser;

    static {
        startBot = new StartBot();
        findUser = new FindUser();
        createUser = new CreateUser();
        functionMap.put("/start", startBot);
        functionMap.put("/find", findUser);
        functionMap.put("/create", createUser);
    }

    public static Function getFunction(String name){
        if (functionMap.containsKey(name)) {
            return functionMap.get(name);
        } else {
            return new Empty();
        }
    }
}
