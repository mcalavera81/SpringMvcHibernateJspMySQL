package com.example.repository.skill;

import com.example.domain.UserJavaSkill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mcalavera81 on 08/04/2017.
 */
public interface UserSkillRepository extends JpaRepository<UserJavaSkill, Integer> {
}
