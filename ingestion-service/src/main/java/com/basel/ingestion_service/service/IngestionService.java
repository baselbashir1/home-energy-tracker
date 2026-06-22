package com.basel.ingestion_service.service;

import com.basel.ingestion_service.dto.EnergyUsageDto;

public interface IngestionService {
    void ingestEnergyUsage(EnergyUsageDto dto);
}