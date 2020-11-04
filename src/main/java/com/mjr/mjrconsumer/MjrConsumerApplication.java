package com.mjr.mjrconsumer;

import com.mjr.mjrconsumer.model.ClassToTeach;
import com.mjr.mjrconsumer.model.Student;
import com.mjr.mjrconsumer.model.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class MjrConsumerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MjrConsumerApplication.class, args);
    }

//    String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpc2lsIiwiaWF0IjoxNjA0NDU2MTAzLCJleHAiOjE2MDQ0NzQxMDN9.jqxwUBTftr3hAF7RvqD14IBhrS21UUt4Xl1LX_6eC1o";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {

    }

    /*private void TeacherById() {
        Integer idTeacher = 1;
        String url = "https://isil-mjr-api.herokuapp.com/api/teachers/" + idTeacher;
        RestTemplate restTemplate = new RestTemplate();
        //sin pasarle el token de autenticacion
        //HttpHeaders headers = new HttpHeaders();
        //headers.set("Authorization", "Bearer "+ accessToken);
        //HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<Teacher> result = restTemplate.exchange(url ,HttpMethod.GET, null, Teacher.class);

        System.out.println("Teacher With Id 1:");
        Teacher teacher = result.getBody();
        System.out.println(teacher);
    }

    private void classByMonth() {
        Integer idTeacher = 1;
        String url = "http://isil-mjr-api.herokuapp.com/api/class-to-teach/by-teacher-month/" + idTeacher;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+ accessToken);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<ArrayList> result = restTemplate.exchange(url ,HttpMethod.GET, entity, ArrayList.class);

        System.out.println("Classes in current month:");
        ArrayList<ClassToTeach> classes = result.getBody();
        System.out.println(classes);
    }

    private void studentsByTeacher(){
        Integer idTeacher = 1;
        String url = "http://isil-mjr-api.herokuapp.com/api/students/by-teacher/" + idTeacher;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+ accessToken);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<ArrayList> result = restTemplate.exchange(url ,HttpMethod.GET, entity, ArrayList.class);

        System.out.println("Students:");
        ArrayList<Student> students = result.getBody();
        System.out.println(students);
    }


*/
}
