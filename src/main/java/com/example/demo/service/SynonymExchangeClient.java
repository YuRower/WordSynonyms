package com.example.demo.service;


import java.net.URL;

import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import com.example.demo.model.Noun;
import com.example.demo.model.SpeechPart;
import com.example.demo.model.SynonymDto;
import com.example.demo.model.Verb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SynonymExchangeClient {

	public <T extends Object & SpeechPart> String[] getWords(Class<T> type,String word) throws IOException {
		String url = "http://words.bighugelabs.com/api/2/05a68f8f413e97e4d6579e9b53782bb5/"+ word +"/json";
		SynonymDto synonym = parseJson(url);
		if (type == Noun.class) {
			return synonym.getNoun().getSyn();
		} else if (type == Verb.class) {
			return synonym.getNoun().getSyn();
		} else {
			return null;
		}
	}

	public static SynonymDto parseJson(String url) throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));
		SynonymDto synonyms = gson.fromJson(jsonReader, SynonymDto.class);
		log.info("Synonyms = " + synonyms);
		return synonyms;
	}
}