package com.travelagency.nastokpl.controllers.view;

import com.travelagency.nastokpl.models.PurchaseEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/trips")
@Slf4j
@RequiredArgsConstructor
public class TripViewController {
    //    Controller responsible for configuring the tour offer by the administrator.
//    It will contain actions for viewing, adding, editing and deleting trips.

    private final TripService tripService;

    @GetMapping
    public String listTrips(Model model) {
        List<TripEntity> trips = tripService.getAllTrips();
        model.addAttribute("allTrips", trips);
        return "trips";
    }

}
