package com.metricsconsumer.rest.mapper;

import com.metricsconsumer.rest.dto.MetricDto;
import com.metricsconsumer.model.Metric;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.UUID;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {MetricDto.class, Metric.class},
        injectionStrategy = CONSTRUCTOR,
        unmappedTargetPolicy = IGNORE)
public interface MetricMapper {

    MetricDto toDto(Metric metric);

    @Mapping(target = "id", source = "id")
    Metric toEntity(MetricDto metric, UUID id);
}
