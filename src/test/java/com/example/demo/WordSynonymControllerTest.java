package com.example.demo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.service.WordSynonymService;
import com.example.demo.web.WordSynonymController;
import com.google.common.collect.ImmutableList;

@RunWith(MockitoJUnitRunner.class)
public class WordSynonymControllerTest {
    @Mock
    private WordSynonymService wordSynonymService;
    @InjectMocks
    WordSynonymController sut;

    @Test
    public void testGetListOfProviders() throws Exception {
        when(wordSynonymService.findAllNouns("house")).thenReturn(ImmutableList.of());
        List<String> listOfProviders = sut.getListOfNouns("house");
        verify(wordSynonymService).findAllNouns("house");
    }
    
    
    @Test
    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
      throws ClientProtocolException, IOException {
      
       String word = "animal";
       String part = "noun";

       HttpUriRequest request = new HttpGet( "http://localhost:8081/api/wordsynonym/"+ part+ "?word="+word );
     
       HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
     
       assertThat(
         httpResponse.getStatusLine().getStatusCode(),
         equalTo(HttpStatus.SC_OK));
    }
}
