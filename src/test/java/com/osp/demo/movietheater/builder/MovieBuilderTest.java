package com.osp.demo.movietheater.builder;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created on 14/06/2018.
 *
 * @author Entelgy
 */
class MovieBuilderTest {

    private MovieBuilder movieBuilder;

    @BeforeEach
    void setUp() {
        movieBuilder = new MovieBuilder();
    }

    @Test
    void MovieBuiltWithIdFieldTest() {
        Assert.assertNull(movieBuilder.build().getId());

        movieBuilder.id(new Long("1"));

        Assert.assertNotNull(movieBuilder.build().getId());
    }

    @Test
    void MovieBuiltWithIdFullNameTest() {
    }

    @Test
    void MovieBuiltWithIdPublishingDateTest() {
    }

    @Test
    void MovieBuiltWithIdStatusTest() {
    }

    @Test
    void MovieBuiltTest() {
    }
}