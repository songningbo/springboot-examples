package com.bccoder.redis.Listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class MyRedisChannelListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {

        byte[] channel = message.getChannel();
        byte[] bs = message.getBody();
        try{
            String context = new String(bs,"UTF-8");
            String pchannel = new String(channel,"UTF-8");
            System.out.println(context+"。 from:"+pchannel);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
