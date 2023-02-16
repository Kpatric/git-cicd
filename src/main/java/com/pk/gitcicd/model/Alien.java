package com.pk.gitcicd.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Alien {
    public int id;
    public String name;
    public String type;

    public void show(){
        System.out.println("is show");
    }
}
