/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.osp.demo.movietheater.controller;

import com.osp.demo.movietheater.DummyMock;
import com.osp.demo.movietheater.business.MovieService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.apache.logging.log4j.util.Strings.EMPTY;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MoviesControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieService movieService;

    @BeforeAll
    public void setUp() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.post("/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DummyMock.getMovieDTOAsString()));
    }

    @Test
    public void getMoviesWhenResponseListTest() throws Exception {
        BDDMockito.given(this.movieService.getMovies())
                .willReturn(DummyMock.getMoviesCollection());

        this.mvc.perform(MockMvcRequestBuilders.get("/movies")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(DummyMock.getMovieDTOCollectionAsString()));
    }

    @Test
    public void getMovieWhenResponseExistsTest() throws Exception {
        BDDMockito.given(this.movieService.getMovie(DummyMock.MOVIE_ID_VALUE))
                .willReturn(DummyMock.getMovie());

        this.mvc.perform(MockMvcRequestBuilders.get("/movies/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(DummyMock.getMovieDTOAsString()));
    }

    @Test
    public void getMovieWhenResponseNotExistsTest() throws Exception {
        BDDMockito.given(this.movieService.getMovie(DummyMock.MOVIE_ID_VALUE))
                .willReturn(DummyMock.getMovie());

        this.mvc.perform(MockMvcRequestBuilders
                .get("/movies/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(EMPTY));
    }

    @Test
    public void createMovieTest() throws Exception {
        BDDMockito.given(this.movieService.saveMovie(DummyMock.getMovie()))
                .willReturn(DummyMock.getMovie());

        BDDMockito.given(this.movieService.getMovie(DummyMock.MOVIE_ID_VALUE))
                .willReturn(DummyMock.getMovie());

        this.mvc.perform(MockMvcRequestBuilders.post("/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DummyMock.getMovieDTOAsString()));

        this.mvc.perform(MockMvcRequestBuilders
                .get("/movies/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(DummyMock.getMovieDTOAsString()));
    }

    @Test
    public void updateMovieTest() throws Exception {
        BDDMockito.given(this.movieService.saveMovie(DummyMock.getMovie()))
                .willReturn(DummyMock.getMovie());

        BDDMockito.given(this.movieService.getMovie(DummyMock.MOVIE_ID_VALUE))
                .willReturn(DummyMock.getMovie());

        this.mvc.perform(MockMvcRequestBuilders.put("/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DummyMock.getMovieDTOAsString()));

        this.mvc.perform(MockMvcRequestBuilders
                .get("/movies/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(DummyMock.getMovieDTOAsString()));
    }

    @Test
    public void deleteMovieTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.delete("/movies/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(EMPTY));
    }
}