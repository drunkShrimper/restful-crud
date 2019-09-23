package com.scau.net17.lipan.restfulcrud.exception;

public class UserNotfoundException extends RuntimeException {

    public UserNotfoundException() {
        super("用户不存在");
    }
}
