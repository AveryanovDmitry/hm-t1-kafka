package com.metricsconsumer.service;

import com.metricsconsumer.rest.mapper.MetricMapper;
import com.metricsconsumer.rest.dto.MetricDto;
import com.metricsconsumer.repository.MetricJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricServiceImpl implements MetricsService {

    private final MetricJpaRepository metricJpaRepository;
    private final MetricMapper mapper;

    @KafkaListener(topics = "metrics-topic", groupId = "metrics-group", containerFactory = "kafkaListenerContainerFactory")
    public void receiveMetrics(MetricDto metric) {
        log.info("Получены метрики из кафки: " + metric);
        metricJpaRepository.save(mapper.toEntity(metric, UUID.randomUUID()));
    }

    public List<MetricDto> getMetrics() {
        return metricJpaRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public MetricDto getMetricById(String id) {
        return mapper.toDto(metricJpaRepository.findById(UUID.fromString(id)).orElseThrow());
    }
}
