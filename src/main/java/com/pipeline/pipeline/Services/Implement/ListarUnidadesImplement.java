package com.pipeline.pipeline.Services.Implement;

import com.pipeline.pipeline.Entity.MiddlewareGob;
import com.pipeline.pipeline.Services.ListarUnidades;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

@Component
public class ListarUnidadesImplement implements ListarUnidades {
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    MiddlewareGob middlewareGob= new MiddlewareGob(restTemplateBuilder);
    Map<String, Object> m = new HashMap<>();
    @Override
    public Object listarUnidades(String resource_id, int limit) throws JSONException {

        Map<String, Object> responseJsonUnidades = new HashMap<>();

        ResponseEntity<String> unidadesApiResponse = new MiddlewareGob(restTemplateBuilder).getTrasport(resource_id,limit);
        JSONObject responseUnidad;
        responseUnidad = new JSONObject(unidadesApiResponse.getBody().replace("\n",""));
        responseJsonUnidades.put("result", String.valueOf(responseUnidad.get("result")));

        return responseJsonUnidades;
    }
}
