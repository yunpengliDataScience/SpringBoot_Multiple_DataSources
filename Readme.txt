http://localhost:7777/SpringBoot_Thymeleaf_Demo/

Access Hal Explorer:
http://localhost:7777/SpringBoot_Thymeleaf_Demo/webjars/hal-explorer/1.1.0/index.html

Access Actuator:
http://localhost:7777/SpringBoot_Thymeleaf_Demo/actuator

Show Prometheus endpoint:
http://localhost:7777/SpringBoot_Thymeleaf_Demo/actuator/prometheus

Add job to prometheus.yml:
- job_name: "SpringBoot_Thymeleaf_Demo"
    scrape_interval: 5s
    metrics_path: "/SpringBoot_Thymeleaf_Demo/actuator/prometheus"
    static_configs:
      - targets: ["localhost:7777"]

Start Prometheus:
>prometheus --config.file=prometheus.yml

Access Prometheus console:
http://localhost:9090

Start Grafana:
>grafana-server

Access Grafana console:
http://localhost:3000
-----------------------------------------------------------------------------------------
Hal Explorer:
https://toedter.github.io/hal-explorer/snapshot/reference-doc/

Spring and Hal:
https://www.baeldung.com/spring-rest-hal

Prometheus:
https://prometheus.io/docs/prometheus/latest/getting_started/

Prometheus and Spring:
https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/
https://www.tutorialworks.com/spring-boot-prometheus-micrometer/
https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.metrics.export.prometheus
https://www.baeldung.com/spring-boot-actuators

Add custom metrics to Spring Boot using Micrometer:
https://fabianlee.org/2022/06/29/java-adding-custom-metrics-to-spring-boot-micrometer-prometheus-endpoint/
https://mucahit.io/2018/08/27/instrumenting-and-monitoring-spring-boot-2-applications/

-----------------------------------------------------------------------
Spring Boot Logging:
https://www.baeldung.com/spring-boot-logging

Spring AOP Pointcut:
https://www.baeldung.com/spring-aop-pointcut-tutorial

-----------------------------------------------------------------------
Jacoco Code Coverage:

https://www.baeldung.com/jacoco
https://www.jacoco.org/jacoco/trunk/index.html

