package com.travelagency.nastokpl.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.dto.ParticipantDTO;
import com.travelagency.nastokpl.dto.PurchaseDTO;
import com.travelagency.nastokpl.dto.TripDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PurchaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "adult_count")
	@Check(constraints = "adult_count >= 0")
	private Integer adultCount;

	@Column(name = "child_count")
	@Check(constraints = "child_count >= 0")
	private Integer childCount;

	@Check(constraints = "adult_count + child_count > 0")

	@Column(name = "total_amount")
	@Digits(integer = 8, fraction = 2)
	private BigDecimal totalAmount;

	@Column(name = "purchase_date")
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "trip_id")
	private TripEntity trip;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<ParticipantEntity> participant;

	public PurchaseDTO toDTO(){
		TripDTO tripDTO = this.trip != null ? this.trip.toDTO() : null;
		List<ParticipantDTO> participantDTOs = this.participant != null ? this.participant.stream().map(ParticipantEntity::toDTO).collect(Collectors.toList()) : null;
		return new PurchaseDTO(this.getId(), tripDTO, participantDTOs);
	}
}
