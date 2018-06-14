package com.osp.demo.movietheater.builder;

import com.osp.demo.movietheater.domain.Movie;

public class MovieBuilder {

    private Long id;
    private String fullName;
    private String publishingDate;
    private String status;

    public MovieBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public MovieBuilder fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public MovieBuilder publishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
        return this;
    }

    public MovieBuilder status(String status) {
        this.status = status;
        return this;
    }

    public Movie build() {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setFullName(fullName);
        movie.setPublishingDate(publishingDate);
        movie.setStatus(status);
        return movie;
    }
}
