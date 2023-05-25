package com.example.SDA.tour.repository;

import com.example.SDA.tour.Tour;
import com.example.SDA.tour.enums.TourType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    //List<Tour> findAllBySpecialIsTrue (TourType type) -- 2 wersja
    @Query(value = "SELECT * FROM tour WHERE is_special=true", nativeQuery = true)
    List<Tour> findPromotedTours();

    @Query("FROM Tour t WHERE t.type = :type")
    List<Tour> findToursByType(TourType type);

    @Query(value="SELECT * FROM tour t WHERE t.date_from < dateadd(day ,3,NOW())" , nativeQuery = true)
    List<Tour> findToursLastMinute();

    @Query(value="SELECT * FROM tour t WHERE t.date_from < dateadd(day ,3,NOW()) and t.type=:type" , nativeQuery = true)
    List<Tour> findToursLastMinuteByType(String type);

/*    @Modifying
    @Query(value = "DELETE tour t WHERE t.date_from < CURRENT_TIMESTAMP()", nativeQuery = true)
    void clearExpiredTours() ;*/

    @Query(value = "SELECT * FROM tour t WHERE t.date_from < NOW()", nativeQuery = true)
    List<Tour> clearExpiredTours();
}
