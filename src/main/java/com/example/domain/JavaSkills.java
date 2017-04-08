package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mcalavera81 on 08/04/2017.
 */
@Entity
@Getter
@Setter
public class JavaSkills {

    public JavaSkills(){

    }

    public JavaSkills(Integer id){
        this.id = id;
    }


    @Id
    private Integer id;

    private String name;



}
