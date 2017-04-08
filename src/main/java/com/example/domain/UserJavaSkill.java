package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by mcalavera81 on 08/04/2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserJavaSkill {

    public UserJavaSkill(String userId, Integer skillId) {
        this.user = new User(userId);
        this.skill = new JavaSkills(skillId);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    private JavaSkills skill;


}
