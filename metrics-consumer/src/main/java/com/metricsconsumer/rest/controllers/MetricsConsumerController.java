package com.metricsconsumer.rest.controllers;

import com.metricsconsumer.rest.dto.MetricDto;
import com.metricsconsumer.service.MetricsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
@Schema(description = "получению метрик из бд")
public class MetricsConsumerController {

    private final MetricsService metricsService;

    @GetMapping()
    @Operation(description = "Получить метрики из бд")
    public List<MetricDto> getMetricsTypes() {
        return metricsService.getMetrics();
    }

    @GetMapping("/{id}")
    @Operation(description = "Получить все записи метрики в базе по ее идентификатору(имени).")
    public MetricDto getMetricsByName(@PathVariable("id") String id) {
        return metricsService.getMetricById(id);
    }
}
