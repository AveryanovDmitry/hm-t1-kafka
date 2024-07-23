package org.openchool.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.openchool.dto.MetricDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.openchool.util.MetricConstant.PROCESS_CPU_TIME;
import static org.openchool.util.MetricConstant.PROCESS_UPTIME;

@Service
@RequiredArgsConstructor
public class MetricServiceImpl implements MetricService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final KafkaTemplate<String, MetricDto> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendMetrics() throws JsonProcessingException {

        List<MetricDto> metrics = new ArrayList<>();

        metrics.add(objectMapper.readValue(
                restTemplate.getForObject(PROCESS_CPU_TIME, String.class), MetricDto.class));
        metrics.add(objectMapper.readValue(
                restTemplate.getForObject(PROCESS_UPTIME, String.class), MetricDto.class));

        metrics.forEach(kafkaTemplate::sendDefault);
    }
}
