package com.osp.demo.movietheater.controller.mapper;

import com.osp.demo.movietheater.DummyMock;
import com.osp.demo.movietheater.domain.Movie;
import com.osp.demo.movietheater.dto.MovieDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.Assert.*;

class MovieMapperTest {

    @InjectMocks
    private MovieMapper movieMapper;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void mapMovieDTOsTest() {
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any()))
                .thenReturn(DummyMock.getMovieDTO());

        List<Movie> movies = DummyMock.getMoviesCollection();
        List<MovieDTO> result = movieMapper.mapMovieDTOs(movies);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(movies.size(), result.size());

        assertEquals(movies.get(0).getId(), result.get(0).getId());
        assertEquals(movies.get(0).getFullName(), result.get(0).getFullName());
        assertEquals(movies.get(0).getPublishingDate(), result.get(0).getPublishingDate());
        assertEquals(movies.get(0).getStatus(), result.get(0).getStatus());
    }

    @Test
    void mapMovieDTOTest() {
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any()))
                .thenReturn(DummyMock.getMovieDTO());

        Movie movie = DummyMock.getMovie();
        MovieDTO result = movieMapper.mapMovieDTO(movie);

        assertNotNull(result);

        assertEquals(movie.getId(), result.getId());
        assertEquals(movie.getFullName(), result.getFullName());
        assertEquals(movie.getPublishingDate(), result.getPublishingDate());
        assertEquals(movie.getStatus(), result.getStatus());
    }

    @Test
    void mapMovieDTONullTest() {
        MovieDTO result = movieMapper.mapMovieDTO(null);

        assertNull(null);
    }

    @Test
    void mapMovieTest() {
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any()))
                .thenReturn(DummyMock.getMovie());

        MovieDTO movieDTO = DummyMock.getMovieDTO();
        Movie result = movieMapper.mapMovie(movieDTO);

        assertNotNull(result);

        assertEquals(movieDTO.getId(), result.getId());
        assertEquals(movieDTO.getFullName(), result.getFullName());
        assertEquals(movieDTO.getPublishingDate(), result.getPublishingDate());
        assertEquals(movieDTO.getStatus(), result.getStatus());
    }

    @Test
    void mapMovieNullTest() {
        Movie result = movieMapper.mapMovie(null);

        assertNull(result);
    }
}