package com.mjr.mjrconsumer.service;

import com.mjr.mjrconsumer.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${resource.url}")
    private String resource;
    @Value("${resource.url}/{id}")
    private String idResource;

    public List<Teacher> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource + "/teachers", Teacher[].class)).collect(Collectors.toList());
    }

    public Teacher create(Teacher teacher) {
        return restTemplate.postForObject(resource + "/teachers", teacher, Teacher.class);
    }

    public Teacher update(Integer id, Teacher teacher) {
        return restTemplate.exchange("/teachers" + idResource, HttpMethod.PUT, new HttpEntity<>(teacher), Teacher.class, id).getBody();
    }

    public void delete(Integer id) {
        restTemplate.delete(resource + "/teachers/" + id);
    }

}

