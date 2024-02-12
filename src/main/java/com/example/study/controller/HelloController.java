package com.example.study.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Controller : Hello!");
        return "hello"; // hello.html을 찾아서 처리
    }

    @GetMapping("hello-mvc")
    public String hellomMvc(@RequestParam(value = "name", required = false) String name,
        Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    @Getter
    @Setter
    static class Hello {
        private String name;
    }
}
