package com.pipeline.pipeline.Controller;

import com.pipeline.pipeline.Services.ListarUnidades;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/unidades")
public class ListarUnidadesController {
    @Autowired
    ListarUnidades listarUnidades;
    @GetMapping
            ("/{resource_id}/listarUnidades/{limit}")
    public ResponseEntity<?> listarUnidadesGob(@PathVariable("resource_id") String resource_id,
                                               @PathVariable("limit")int limit) throws JSONException{
        Object listaUGob = listarUnidades.listarUnidades(resource_id, limit);
        return new ResponseEntity(listaUGob, HttpStatus.OK);
    }
}
