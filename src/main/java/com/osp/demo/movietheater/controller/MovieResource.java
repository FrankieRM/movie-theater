package com.osp.demo.movietheater.controller;

import com.osp.demo.movietheater.business.MovieService;
import com.osp.demo.movietheater.controller.mapper.MovieMapper;
import com.osp.demo.movietheater.dto.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieResource {

    private final Logger LOGGER = LoggerFactory.getLogger(MovieResource.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping("/movies")
    public List<MovieDTO> getMovies() {
        LOGGER.info("Calling MovieResource.getMovies resource");
        return movieMapper.mapMovieDTOs(movieService.getMovies());
    }

    @GetMapping("/movies/{id}")
    public MovieDTO getMovie(@PathVariable Long id) {
        LOGGER.info("Calling MovieResource.getMovie resource");
        return movieMapper.mapMovieDTO(movieService.getMovie(id));
    }

    @PostMapping("/movies")
    public MovieDTO createMovie(@RequestBody MovieDTO movieDTO) {
        LOGGER.info("Calling MovieResource.createMovie resource");
        return movieMapper.mapMovieDTO(movieService.saveMovie(movieMapper.mapMovie(movieDTO)));
    }

    @PutMapping("/movies")
    public MovieDTO updateMovie(@RequestBody MovieDTO movieDTO) {
        LOGGER.info("Calling MovieResource.updateMovie resource");
        return movieMapper.mapMovieDTO(movieService.saveMovie(movieMapper.mapMovie(movieDTO)));
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Long id) {
        LOGGER.info("Calling MovieResource.deleteMovie resource");
        movieService.deleteMovie(id);
    }
}
