package domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LikesTest {

    Movie movie = Movie.builder()
            .movieId("1")
            .movieTitle("기생충")
            .movieDirector("봉준호")
            .moviePoster("https://img.movist.com/?img=/x00/05/04/96_p1.jpg")
            .movieType("스릴러")
            .movieReleaseDate(new Date()) //양방향은 어떻게 함? (reivewList)
            .build();

    User user = User.builder()
            .userId(1)
            .userAccountId("coocoa389")
            .userPasswd("1234")
            .userName("김지혜")
            .userBirthday(new Date())
            .build();//양방향 우짬? (reivewList, likeList)

    Rating rating = Rating.builder().ratingId(1).ratingScore(1).build();
    Review review = Review.builder().movie(movie).user(user).reviewContent("ㅋㅋ").rating(rating).build();
    Likes like = Likes.builder().build();
    @Test
    void getLikesId() {
    }

    @Test
    void getUser() {
    }

    @Test
    void getReview() {
    }

    @Test
    void isLikes() {
    }

    @Test
    void testToString() {
    }

    @Test
    void builder() {
    }
}