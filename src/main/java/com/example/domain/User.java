package com.example.domain;

/**
 * Created by mcalavera81 on 07/04/2017.
 */

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    public User(String id){
        this.id =id;
    }

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    @Column(name = "password", nullable = false)
    private String password;

    private String gender;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserJavaSkill> skills;



    public User(final String id, final String password, String gender, Integer countryId, List<Integer> javaSkills) {
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.country = new Country(countryId);
        this.skills= javaslang.collection.List.ofAll(javaSkills).map(skillId -> new UserJavaSkill(id,skillId)).toJavaList();
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("password", password)
                .toString();
    }
}
