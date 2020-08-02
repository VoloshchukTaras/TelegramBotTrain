package com.friend.bot;

import com.friend.persistence.model.Friend;
import com.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;


public class AnswerBot extends TelegramLongPollingBot {
    @Autowired
    private FriendService friendService;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if(update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();

                switch (inMessage.getText()){
                    case ("Як справи?"):
                        SendMessage outMessage = new SendMessage();
                        outMessage.setChatId(inMessage.getChatId());
                        outMessage.setText("Справи добре.");
                        execute(outMessage);
                        break;
                    case ("Які у тебе хоббі?"):
                        SendMessage outMessage1 = new SendMessage();
                        outMessage1.setChatId(inMessage.getChatId());
                        outMessage1.setText("Люблю читати книги, підтягуватись на турніку," +
                                "віджиматись на брусях, плавати.");
                        execute(outMessage1);
                        break;
                    case ("А які книги любиш читати?"):
                        SendMessage outMessage2 = new SendMessage();
                        outMessage2.setChatId(inMessage.getChatId());
                        outMessage2.setText("Люблю читати психологію, інколи звичайні художні книги." +
                                "Все залежить від настрою.");
                        execute(outMessage2);
                        break;
                    default:
                        SendMessage outMessage3 = new SendMessage();
                        outMessage3.setChatId(inMessage.getChatId());
                        outMessage3.setText("Не зрозумів питання. Повторіть, будь-ласка.");
                        execute(outMessage3);
                        SendMessage outMessage31 = new SendMessage();
                        outMessage31.setChatId(inMessage.getChatId());
                        outMessage31.setText("Hello!");
                        execute(outMessage31);
                }
                List<Friend> list = friendService.getObjects();
                Friend friend = list.get(1);
                SendMessage outMessage4 = new SendMessage();
                outMessage4.setChatId(inMessage.getChatId());
                outMessage4.setText((friend.getOutMessage()));
                execute(outMessage4);

            }
        }catch (TelegramApiException e){
            e.printStackTrace();
        }



    }




                /*
                List<Friend> list = friendService.getObjects();

                SendMessage outMessage3 = new SendMessage();
                outMessage3.setChatId(inMessage.getChatId());
                outMessage3.setText("Привіт");
                execute(outMessage3);

                int count = 0;
               // for(int i=0;i<list.size();i++){
                 //   Friend friend = list.get(i);
                //}
                //for (Friend friend : list) {
                    for(int i=0;i<list.size();i++){
                        Friend friend = list.get(i);

                    if (inMessage.equals(friend.getInMessage())) {
                        SendMessage outMessage = new SendMessage();
                        outMessage.setChatId(inMessage.getChatId());
                        outMessage.setText(friend.getOutMessage());
                        execute(outMessage);
                        count++;
                        break;
                    }
                }
                if(count == 0){
                    SendMessage outMessage1 = new SendMessage();
                    outMessage1.setChatId(inMessage.getChatId());
                    outMessage1.setText("Не зрозумів питання. Повторіть, будь-ласка.");
                    execute(outMessage1);
                }

                switch (inMessage.getText()){
                    case ("Як справи?"):
                        SendMessage outMessage = new SendMessage();
                        outMessage.setChatId(inMessage.getChatId());
                        outMessage.setText("Справи добре.");
                        execute(outMessage);
                        break;
                    case ("Які у тебе хоббі?"):
                        SendMessage outMessage1 = new SendMessage();
                        outMessage1.setChatId(inMessage.getChatId());
                        outMessage1.setText("Люблю читати книги, підтягуватись на турніку," +
                                "віджиматись на брусях, плавати.");
                        execute(outMessage1);
                        break;
                    case ("А які книги любиш читати?"):
                        SendMessage outMessage2 = new SendMessage();
                        outMessage2.setChatId(inMessage.getChatId());
                        outMessage2.setText("Люблю читати психологію, інколи звичайні художні книги." +
                                "Все залежить від настрою.");
                        execute(outMessage2);
                        break;
                    default:
                        SendMessage outMessage3 = new SendMessage();
                        outMessage3.setChatId(inMessage.getChatId());
                        outMessage3.setText("Не зрозумів питання. Повторіть, будь-ласка.");
                        execute(outMessage3);
                }


                //SendMessage outMessage = new SendMessage();
                //outMessage.setChatId(inMessage.getChatId());
                //outMessage.setText(inMessage.getText());
                //execute(outMessage);

                 */


    @Override
    public String getBotUsername() {
        return "Friend1991Bot";
    }

    @Override
    public String getBotToken() {
        return "1214313066:AAGpBVsMY52NC1hZpwyLc9-WNb1tmGZ-lFo";
    }
}
