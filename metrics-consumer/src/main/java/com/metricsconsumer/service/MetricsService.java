package com.metricsconsumer.service;

import com.metricsconsumer.rest.dto.MetricDto;

import java.util.List;

public interface MetricsService {

    List<MetricDto> getMetrics();

    MetricDto getMetricById(String id);

}
