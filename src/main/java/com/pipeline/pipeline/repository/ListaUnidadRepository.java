package com.pipeline.pipeline.repository;

import com.pipeline.pipeline.Dto.ListarUnidadesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaUnidadRepository extends JpaRepository<ListarUnidadesDto, Integer> {

    @Query(value = "INSERT INTO databus VALUES (iddata= null, _id=:_id, nombre=:nombre, " +
            "geo_point_2d=:geo_point_2d, operating=:operating, line=:line)", nativeQuery = true)
    void saveUnidades(@Param("_id") int _id, @Param("nombre") String nombre,@Param("geo_point_2d") String geo_point_2d,
    @Param("operating") String operating, @Param("line")int line);
}
