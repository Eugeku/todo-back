package org.eug.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path="/", produces = "application/json")
    String hello() {
        return "Hello World!";
    }
}