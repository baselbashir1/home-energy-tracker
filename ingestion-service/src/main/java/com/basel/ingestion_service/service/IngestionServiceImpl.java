package com.basel.ingestion_service.service;

import com.basel.ingestion_service.dto.EnergyUsageDto;
import com.basel.ingestion_service.kafka.event.EnergyUsageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngestionServiceImpl implements IngestionService {

    private final KafkaTemplate<String, EnergyUsageEvent> kafkaTemplate;

    @Override
    public void ingestEnergyUsage(EnergyUsageDto dto) {
        EnergyUsageEvent event = EnergyUsageEvent.builder()
                .deviceId(dto.deviceId())
                .energyConsumed(dto.energyConsumed())
                .timestamp(dto.timestamp())
                .build();

        kafkaTemplate.send("energy-usage", event);
        log.info("Ingested energy usage event: {}", event);
    }
}