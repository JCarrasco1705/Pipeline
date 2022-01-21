package com.pipeline.pipeline.Dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "databus")
@Data
public class ListarUnidadesDto implements Serializable {
    @Id
    @Column(name = "iddata", nullable = false)
    private int id;
    private int _id;
    private String nombre;
    private String geo_point_2d;
    private String operating;
    private int line;

}
