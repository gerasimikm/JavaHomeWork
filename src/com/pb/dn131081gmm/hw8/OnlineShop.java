package com.pb.dn131081gmm.hw8;

import java.util.Scanner;
import java.util.regex.Pattern;

public class OnlineShop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Регистрация пользователя.");
        System.out.print("\nВведите логин: ");
        String lgn = in.nextLine();
        System.out.print("\nВведите пароль: ");
        String pswd = in.nextLine();
        System.out.print("\nВведите пароль повторно: ");
        String confPswd = in.nextLine();

        Auth authorization = new Auth();
        try {
            authorization.signUp(lgn, pswd, confPswd);
        } catch (WrongLoginException ex) {
            System.out.println(ex.getMessage());
        } catch (WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        } catch (WrongConfPswdException ex) {
            System.out.println(ex.getMessage());
        }
        if (null != authorization.getLogin()) {
            System.out.println("Авторизация пользователя.");
            System.out.print("\nВведите логин: ");
            lgn = in.nextLine();
            System.out.print("\nВведите пароль: ");
            pswd = in.nextLine();
            try {
                authorization.signIn(lgn, pswd);
            } catch (WrongLoginException ex) {
                System.out.println(ex.getMessage());
            } catch (WrongPasswordException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

