package org.eug.todo;

import org.eug.todo.service.impl.DBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        DBManager.startDB();
        DBManager.createTable();
        SpringApplication.run(App.class, args);
    }
}