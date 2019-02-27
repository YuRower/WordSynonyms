package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.WordSynonymService;

import java.util.List;

@RestController
@RequestMapping("/api/wordsynonym")
public class WordSynonymController {
	
    @Autowired
    private WordSynonymService synonymService;
    @RequestMapping("/noun")
    public List<String> getListOfNouns(@RequestParam(value="word" ,required=true) String  word) {
        return synonymService.findAllNouns(word);
    }
    @RequestMapping("/verb")
    public List<String> getListOfVerbs(@RequestParam(value="word" ,required=true) String word) {
        return synonymService.findAllVerbs(word );
    }
}