package com.controller;

import com.common.JoyResult;

public interface UserController {

public JoyResult login(String tel, String password);
public JoyResult register(String userInfo);
}
