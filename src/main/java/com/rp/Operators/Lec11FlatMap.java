package com.rp.Operators;

import com.rp.Operators.helper.OrderService;
import com.rp.Operators.helper.UserService;
import com.rp.utils.Util;

import java.io.BufferedReader;

public class Lec11FlatMap {

    public static void main(String[] args) {

        BufferedReader reader;


        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId())) // mono / flux
                // .filter(p -> p > 10)
                .subscribe(Util.subscriber());


        Util.sleepSeconds(60);
    }
}
