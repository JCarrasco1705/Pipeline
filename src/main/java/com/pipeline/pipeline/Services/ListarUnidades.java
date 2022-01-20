package com.pipeline.pipeline.Services;

import org.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public interface ListarUnidades {
    public Object listarUnidades(String resource_id, int limit)throws JSONException;
}
