package com.xmsx24.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO dao;

    @Override
    public Message register(UserBean user) {
        Message message = new Message();
        if(user.getUsername()==null || user.getPassword()==null){
            message.setState(false);
            message.setMessage("未输入账号或密码");
            return message;
        }
        UserBean duplicate = dao.findByUsername(user.getUsername());
        if(duplicate != null){
            message.setState(false);
            message.setMessage("该账号已被注册");
            return message;
        }
        UserBean result = dao.save(user);
        message.setState(true);
        message.setMessage("注册成功");
        return message;
    }

    @Override
    public Message login(UserBean user) {
        Message message = new Message();
        if(user.getUsername()==null || user.getPassword()==null){
            message.setState(false);
            message.setMessage("未输入账号或密码");
            return message;
        }
        UserBean result = dao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(result != null) {
            message.setState(true);
            message.setMessage("登陆成功");
            message.setToken(result.getId());
            return message;
        }
        message.setState(false);
        message.setMessage("用户名或密码错误");
        message.setToken("");
        return message;
    }
}
