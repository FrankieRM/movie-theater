package com.osp.demo.movietheater;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osp.demo.movietheater.domain.Movie;
import com.osp.demo.movietheater.domain.MovieStatus;
import com.osp.demo.movietheater.dto.MovieDTO;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public final class DummyMock {

    private DummyMock() {
    }

    public static final Long MOVIE_ID_VALUE = new Long("1");
    public static final String MOVIE_FULL_NAME_VALUE = "Juan Perez";
    public static final String MOVIE_PUBLISHING_DATE_VALUE = LocalDateTime
            .of(2018, 6, 14, 20, 40, 59).toString();

    public static List<Movie> getMoviesCollection() {
        return Collections.singletonList(getMovie());
    }

    public static Movie getMovie() {
        Movie movie = new Movie();
        movie.setId(DummyMock.MOVIE_ID_VALUE);
        movie.setFullName(DummyMock.MOVIE_FULL_NAME_VALUE);
        movie.setPublishingDate(DummyMock.MOVIE_PUBLISHING_DATE_VALUE);
        movie.setStatus(MovieStatus.ACTIVE.toString());
        return movie;
    }

    public static MovieDTO getMovieDTO() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(DummyMock.MOVIE_ID_VALUE);
        movieDTO.setFullName(DummyMock.MOVIE_FULL_NAME_VALUE);
        movieDTO.setPublishingDate(DummyMock.MOVIE_PUBLISHING_DATE_VALUE);
        movieDTO.setStatus(MovieStatus.ACTIVE.toString());
        return movieDTO;
    }

    public static String getMovieDTOAsString() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(DummyMock.getMovieDTO());
    }
}
