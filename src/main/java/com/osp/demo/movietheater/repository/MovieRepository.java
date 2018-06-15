package com.osp.demo.movietheater.repository;

import com.osp.demo.movietheater.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
