package com.example.epam_examinator.api;

import com.example.epam_examinator.model.Exam;
import com.example.epam_examinator.model.Question;
import com.example.epam_examinator.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public ExamController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @PostMapping
    public Exam exam(@RequestBody Map<String, Integer> spec) {
        List<Section> sections = spec.entrySet().stream()
                .map(this::getUrl)
                .map(url -> restTemplate.getForObject(url, Question[].class))
                .map(Arrays::asList)
                .map(Section::new)
                .toList();
        return new Exam("EXAM", sections);
    }

    private String getUrl(Map.Entry<String, Integer> entry) {
        return discoveryClient.getInstances(entry.getKey())
                .stream()
                .findFirst()
                .map(serviceInstance -> serviceInstance.getUri() + "/api/questions/" + entry.getValue())
                .orElse("");
    }
}