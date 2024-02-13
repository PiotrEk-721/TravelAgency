package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.models.ParticipantEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDTO {
	private Long id;
	private PurchaseDTO purchaseDTO;

	public ParticipantEntity toEntity(){
		return null;
	}

}
