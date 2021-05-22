package com.example.restservice;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Greeting {
    private long id;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
