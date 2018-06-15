package com.osp.demo.movietheater.business;

import com.osp.demo.movietheater.domain.Movie;
import com.osp.demo.movietheater.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Long id) {
        if (movieRepository.existsById(id)) {
            return movieRepository.getOne(id);
        }
        return null;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
