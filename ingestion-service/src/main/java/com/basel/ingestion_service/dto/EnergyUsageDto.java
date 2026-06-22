package com.basel.ingestion_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Builder
@ToString
public class EnergyUsageDto {
    private Long deviceId;
    private double energyConsumed;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant timestamp;
}