package com.example.service.skill;

import com.example.domain.JavaSkills;
import com.example.repository.skill.JavaSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mcalavera81 on 08/04/2017.
 */
@Service
public class SkillServiceImpl implements  SkillService {

    @Autowired
    private JavaSkillRepository skillRepository;

    @Override
    public List<JavaSkills> getAllSkills() {
        return skillRepository.findAll();
    }
}
