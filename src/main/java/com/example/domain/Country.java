package com.example.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mcalavera81 on 08/04/2017.
 */
@Data
@Getter
@Setter
@Entity
public class Country {

    public Country(){}

    public Country(Integer id){
        this.id = id;
    }

    @Id
    private Integer id;

    private String name;


}
