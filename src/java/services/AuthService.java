/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.pojo.User;
/**
 *
 * @author 7853j
 */
public class AuthService {
    public static String sayHello(String name) {
        return "Hello " + name + "!";
    }
    public int check(User user){
        System.out.println("2");
        return 1;
    }
}
