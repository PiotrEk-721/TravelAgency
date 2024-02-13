package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.dto.PurchaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {
	private Long id;
	private List<PurchaseDTO> purchases;
	private CityDTO departureCityDTO;
	private CityDTO destinationCityDTO;


}
