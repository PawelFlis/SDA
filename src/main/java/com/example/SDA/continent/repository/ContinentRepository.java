package com.example.SDA.continent.repository;

import com.example.SDA.continent.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {

    Optional<Continent> findContinentByName(String continentName);

}
