package com.example.messagesendmailphone.service;

import com.example.messagesendmailphone.Utils.RandomUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author hso
 * @data: 2019/11/29 17:29
 * @param:
 * @description:
 */
@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSms(String mobile) {
        //生成6位数验证码
        String checkcode = RandomUtil.generateString(6);
        //验证码存入缓存,为了注册的时候校验验证码是否正确
        redisTemplate.opsForValue().set("checkcode"+mobile,checkcode,5, TimeUnit.MINUTES);
        //验证码放入消息队列
        Map<String,String> map = new HashMap();
        map.put("mobile",mobile);
        map.put("checkcode",checkcode);
        rabbitTemplate.convertAndSend("sms",map);
    }
}
