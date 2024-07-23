package org.openchool.util;

import org.springframework.stereotype.Component;

@Component
public class MetricConstant {

    private MetricConstant() {
    }

    public static final String PROCESS_CPU_TIME = "http://localhost:8091/actuator/metrics/process.cpu.time";
    public static final String PROCESS_UPTIME = "http://localhost:8091/actuator/metrics/process.uptime";
    public static final String JVM_MEMORY_USED = "http://localhost:8091/actuator/metrics/jvm.memory.used";
    public static final String JVM_MEMORY_COMMITTED = "http://localhost:8091/actuator/metrics/jvm.memory.committed";
}
