package com.example.messagesendmailphone.controller;

import com.example.messagesendmailphone.comon.CodeEnum;
import com.example.messagesendmailphone.comon.ResponseData;
import com.example.messagesendmailphone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hso
 * @data: 2019/12/4 11:12
 * @param:
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {


        @Autowired
        private UserService userService;

        @PostMapping(value="/sendsms/{mobile}")
        public ResponseData sendsms(@PathVariable String mobile ){
            userService.sendSms(mobile);
            return ResponseData.out(CodeEnum.SUCCESSS,"发送成功");
        }
    }

