package org.openchool.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.openchool.service.MetricService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
@Tag(name = "Продюсер контроллер", description = "Обрабатывает входящие запросы отправки метрик через кафку")
public class ProducerController {

    private final MetricService producer;

    @PostMapping()
    @Operation(description = "Отправляет в другой сервис отслеживаемые метрики")
    public String sendMetrics() throws JsonProcessingException {
        producer.sendMetrics();
        return "Метрики отправлены";
    }
}
