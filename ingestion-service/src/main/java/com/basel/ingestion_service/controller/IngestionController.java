package com.basel.ingestion_service.controller;

import com.basel.ingestion_service.dto.EnergyUsageDto;
import com.basel.ingestion_service.service.IngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingestion")
public class IngestionController {

    private final IngestionService ingestionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void ingestData(@RequestBody EnergyUsageDto dto) {
        ingestionService.ingestEnergyUsage(dto);
    }
}