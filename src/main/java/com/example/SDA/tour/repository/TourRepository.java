package com.example.SDA.tour.repository;

import com.example.SDA.tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    @Query(value = "SELECT TOP 200 * FROM tour ORDER BY date_from", nativeQuery = true)
    List<Tour> findTop200Tours();
}
