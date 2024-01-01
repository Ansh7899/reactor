package com.rp.Operators.helper;

import com.rp.utils.Util;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class Person {


    private String name;
    private Integer age;

    public Person(){
        this.name = Util.faker().name().fullName();
        this.age = Util.faker().random().nextInt(1,30);
    }
}
