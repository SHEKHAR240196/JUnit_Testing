package com.shekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shekhar.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{

}
