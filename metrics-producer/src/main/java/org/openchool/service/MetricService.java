package org.openchool.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MetricService {

    void sendMetrics() throws JsonProcessingException;
}
