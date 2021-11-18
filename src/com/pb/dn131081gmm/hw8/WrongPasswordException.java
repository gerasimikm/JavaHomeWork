package com.pb.dn131081gmm.hw8;

public class WrongPasswordException extends  Exception{
    public WrongPasswordException() {
    }
    public WrongPasswordException(String str) {
        super(str);
    }
}
