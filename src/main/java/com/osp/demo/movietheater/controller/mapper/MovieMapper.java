package com.osp.demo.movietheater.controller.mapper;

import com.osp.demo.movietheater.domain.Movie;
import com.osp.demo.movietheater.controller.dto.MovieDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    @Autowired
    private ModelMapper modelMapper;

    public List<MovieDTO> mapMovieDTOs(final List<Movie> movies) {
        return movies
                .stream()
                .map(this::mapMovieDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO mapMovieDTO(final Movie movie) {
        if (movie == null) {
            return null;
        }
        return modelMapper.map(movie, MovieDTO.class);
    }

    public Movie mapMovie(final MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }
}
