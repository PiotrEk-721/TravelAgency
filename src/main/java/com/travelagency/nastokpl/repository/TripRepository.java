package com.travelagency.nastokpl.repository;

import com.travelagency.nastokpl.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
@ResponseBody
public interface TripRepository extends JpaRepository<Trip, Long>{

    //For MainPageController
    List<Trip> findTripsByStartDateAfter(LocalDate currentDate);

    List<Trip> findTripsByPurchaseDateAfter(LocalDate startDate);


    List<Trip> findTripsByPromotedIsTrue();
}
