package com.osp.demo.movietheater.controller;

import com.osp.demo.movietheater.DummyMock;
import com.osp.demo.movietheater.business.MovieService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class MovieResourceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        BDDMockito.given(movieService.getMovie(Mockito.anyLong()))
                .willReturn(DummyMock.getMovie());
    }

    void test(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/movies/{id}", String.class, "123");
        Assert.assertNotNull(responseEntity);
    }
}