package com.pipeline.pipeline.Services.Implement;

import com.pipeline.pipeline.Dto.ListarUnidadesDto;
import com.pipeline.pipeline.Entity.ListaUnidadesResponse;
import com.pipeline.pipeline.Entity.MiddlewareGob;
import com.pipeline.pipeline.Services.ListarUnidades;
import com.pipeline.pipeline.repository.ListaUnidadRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ListarUnidadesImplement implements ListarUnidades{


    ListaUnidadRepository listaUnidadRepository = new ListaUnidadRepository() {
        @Override
        public void saveUnidades(int _id, String nombre, String geo_point_2d, String operating, int line) {

        }

        @Override
        public List<ListarUnidadesDto> findAll() {
            return null;
        }

        @Override
        public List<ListarUnidadesDto> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<ListarUnidadesDto> findAllById(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public <S extends ListarUnidadesDto> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends ListarUnidadesDto> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends ListarUnidadesDto> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<ListarUnidadesDto> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public ListarUnidadesDto getOne(Integer integer) {
            return null;
        }

        @Override
        public ListarUnidadesDto getById(Integer integer) {
            return null;
        }

        @Override
        public <S extends ListarUnidadesDto> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends ListarUnidadesDto> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<ListarUnidadesDto> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends ListarUnidadesDto> S save(S entity) {
            return null;
        }

        @Override
        public Optional<ListarUnidadesDto> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(ListarUnidadesDto entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> integers) {

        }

        @Override
        public void deleteAll(Iterable<? extends ListarUnidadesDto> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends ListarUnidadesDto> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends ListarUnidadesDto> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends ListarUnidadesDto> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends ListarUnidadesDto> boolean exists(Example<S> example) {
            return false;
        }
    };
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    MiddlewareGob middlewareGob= new MiddlewareGob(restTemplateBuilder);
    Map<String, Object> m = new HashMap<>();
    ListaUnidadesResponse listaUnidadesResponse = new ListaUnidadesResponse();
    @Override
    public Object listarUnidades(String resource_id, int limit) throws JSONException {

        Map<String, Object> responseJsonUnidades = new HashMap<>();

        ArrayList listaUnidades = new ArrayList<>();
        ResponseEntity<String> unidadesApiResponse = new MiddlewareGob(restTemplateBuilder).getTrasport(resource_id, limit);
        JSONObject responseUnidad;
        responseUnidad = new JSONObject(unidadesApiResponse.getBody().replace("\n", ""));
            JSONObject records = (JSONObject) responseUnidad.get("result");
        JSONArray name = (JSONArray) records.get("records");
            for(int i= 0; i < name.length(); i++){
                JSONObject objeto = name.getJSONObject(i);
                int idb = objeto.getInt("_id");
                String nombreUnidad = objeto.getString("nombre");
                String goepoint = objeto.getString("geo_point_2d");
                String operating = objeto.getString("operating");
                int line = objeto.getInt("line");

                responseJsonUnidades.put("_id", idb);
                responseJsonUnidades.put("nombre", nombreUnidad);
                responseJsonUnidades.put("geo_point_2d", goepoint);
                responseJsonUnidades.put("operating", operating);
                responseJsonUnidades.put("line", line);

                listaUnidadesResponse.set_id(Integer.parseInt(String.valueOf(responseJsonUnidades.get("_id"))));
                listaUnidadesResponse.setNombre(String.valueOf(responseJsonUnidades.get("nombre")));
                listaUnidadesResponse.setGeo_point_2d(String.valueOf(responseJsonUnidades.get("geo_point_2d")));
                listaUnidadesResponse.setOperating(String.valueOf(responseJsonUnidades.get("operating")));
                listaUnidadesResponse.setLine(Integer.parseInt(String.valueOf(responseJsonUnidades.get("line"))));
                listaUnidades.add(listaUnidadesResponse.toString());
                listaUnidadRepository.saveUnidades(listaUnidadesResponse.get_id(), listaUnidadesResponse.getNombre(),
                        listaUnidadesResponse.getGeo_point_2d(), listaUnidadesResponse.getOperating(), listaUnidadesResponse.getLine());


            }
        return listaUnidades;
    }

}
