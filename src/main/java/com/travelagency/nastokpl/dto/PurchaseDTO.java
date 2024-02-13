package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.models.ParticipantEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {
	private Long id;
	private TripDTO tripDTO;
	private List<ParticipantDTO> participantDTOs;

	public ParticipantEntity toEntity(){
		return null;
	}
}
