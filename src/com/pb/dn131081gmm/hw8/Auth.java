package com.pb.dn131081gmm.hw8;

import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password=null;

    public void signUp(String lgn, String pswd, String cofPswd) throws WrongConfPswdException, WrongLoginException, WrongPasswordException {
        if (!(Pattern.matches("[a-zA-Z0-9]+", lgn) && (lgn.length() > 4 && lgn.length() < 21)))
            throw new WrongLoginException("Логин содержит недопустимые символы");
        if (!Pattern.matches("[a-zA-Z0-9_]+", pswd))
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        if (pswd.length() < 5)
            throw new WrongPasswordException("В пароле должно быть не менее 6ти допустимых символов");
        if (!pswd.equals(cofPswd)) throw new WrongConfPswdException("Пароли не совпадают");
        this.login = lgn;
        this.password = pswd;
    }

    public void signIn(String lgn, String pswd) throws WrongLoginException, WrongPasswordException {
        if (!((this.login).equalsIgnoreCase(lgn))) throw new WrongLoginException("Не существующий логин");
        if (!(this.password).equals(pswd)) throw new WrongPasswordException("Ошибка при вводе пароля");
        System.out.println("Добро пожалловать!");
    }

    public String getLogin() {
        return login;
    }
}
