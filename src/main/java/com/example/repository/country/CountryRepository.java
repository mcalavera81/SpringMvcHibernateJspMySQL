package com.example.repository.country;

import com.example.domain.Country;
import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mcalavera81 on 08/04/2017.
 */
public interface CountryRepository extends JpaRepository<Country, String> {
}
