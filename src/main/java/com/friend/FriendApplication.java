package com.friend;

import com.friend.bot.AnswerBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@SpringBootApplication
@EnableScheduling
public class FriendApplication  {
    public static void main(String[] args) {

        SpringApplication.run(FriendApplication.class, args);


        // Initialize Api Context
        ApiContextInitializer.init();

        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Register our bot
        try {
            botsApi.registerBot(new AnswerBot());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }

}
