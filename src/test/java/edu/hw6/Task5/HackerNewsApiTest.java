package edu.hw6.Task5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class HackerNewsApiTest {
    @Test
    public void hackerNewsTopStoriesTest() {
        assertThat(HackerNewsApi.hackerNewsTopStories().length).isNotEqualTo(0);
    }

    @Test
    public void newsTest() {
        assertThat(HackerNewsApi.news(5)).isNotNull().isNotEqualTo("");
    }
}