package com.pipeline.pipeline.Entity;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MiddlewareGob {

private final RestTemplate restTemplate;

    public MiddlewareGob(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> getTrasport(String resource_id, int limit){
        String url ="https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id="+resource_id+"&limit="+limit;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, request, String.class);
    }

}
