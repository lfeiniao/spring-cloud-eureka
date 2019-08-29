package com.ly.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
	@Value("${neo.hello}")
    private String hello;

    @GetMapping("/hello")
    public String from() {
        return this.hello;
    }
}
