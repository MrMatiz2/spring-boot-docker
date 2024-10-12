package com.example.spring_boot_docker;

import com.example.spring_boot_docker.controller.MainController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class SpringBootDockerApplicationTests {

    @Autowired
    private MainController mainController;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testAppMessage() {
        assertEquals("Hello World", mainController.home());
    }

    @Test
    void testAppMessageREST(){
        ResponseEntity<String> response = restTemplate
                .getForEntity("/", String.class);
        assertEquals("Hello World", response.getBody());
    }

}
