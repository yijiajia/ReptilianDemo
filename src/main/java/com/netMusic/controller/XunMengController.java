package com.netMusic.controller;

import com.netMusic.service.impl.XunMengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class XunMengController {

    @Autowired
    private XunMengService xunMengService;

    @PostMapping(value = "/saveAll")
    public String saveAll(String songName){

        if(songName!=null){
            xunMengService.saveAllBySongName(songName);
            return "success";
        }else{
            return "error";
        }

    }


    @GetMapping(value = "/saveAllByName")
    public String saveAllByName(){

        String test = "abcdefghijklnmopqrstuvwxyz";
        for(int i=0;i<test.length();i++){
            String songName = test.charAt(i)+"";
            xunMengService.saveAllBySongName(songName);
        }

        return "success";
    }

}
