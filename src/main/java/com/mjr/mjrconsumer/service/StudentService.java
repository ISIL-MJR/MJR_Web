package com.mjr.mjrconsumer.service;

import com.mjr.mjrconsumer.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${resource.url}")
    private String resource;
    @Value("${resource.url}/{id}")
    private String idResource;

    public List<Student> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, Student[].class)).collect(Collectors.toList());
    }

    public Student create(Student student) {
        return restTemplate.postForObject(resource, student, Student.class);
    }

    public Student update(Integer id, Student student) {
        return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(student), Student.class, id).getBody();
    }

    public void delete(Integer id) {
        restTemplate.delete(idResource, id);
    }
}
