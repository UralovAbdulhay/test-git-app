package com.example.controller;

import com.example.entity.Count;
import com.example.repository.CounterRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    private final CounterRepository repository;

    public CountController(CounterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/**")
    public Count getData9(@RequestHeader ("Cookie") String cookie){
        Count count=getCount(cookie);
        count.increase();
        repository.save(count);
        return count;
    }
    @GetMapping("/count")
    public Count getData10(@RequestHeader ("Cookie") String cookie){
        return  getCount(cookie);
    }

    private Count getCount(String cookie) {
        cookie=cookie.split(";")[0];
//        Count count = repository.findBySession(cookie).orElse(new Count(cookie));
        return null;
    }
}
