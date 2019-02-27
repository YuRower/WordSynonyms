package com.example.demo.service;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Noun;
import com.example.demo.model.Verb;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WordSynonymService {
	@Autowired
	private SynonymExchangeClient sysonymExchangeClient;

	public List<String> findAllNouns(String word) {
		try {
			return Arrays.asList(sysonymExchangeClient.getWords(Noun.class, word));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public List<String> findAllVerbs(String word) {
		try {
			return Arrays.asList(sysonymExchangeClient.getWords(Verb.class, word));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}
}