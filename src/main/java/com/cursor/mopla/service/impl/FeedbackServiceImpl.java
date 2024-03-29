package com.cursor.mopla.service.impl;

import com.cursor.mopla.entities.Feedback;
import com.cursor.mopla.repositories.FeedbackRepository;
import com.cursor.mopla.repositories.MovieRepository;
import com.cursor.mopla.repositories.UserRepository;
import com.cursor.mopla.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(UserRepository userRepository, MovieRepository movieRepository, FeedbackRepository feedbackRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback create(Feedback feedback, Long movieId, Long userId) {

        if (feedback == null || movieId == null || movieId < 0 || userId == null || userId < 0) {
            throw new IllegalArgumentException("You must enter correct data");
        }

        final var movie = movieRepository.getById(userId);
        feedback.setUser(userRepository.getById(userId));
        feedback.setMovie(movie);
        feedback = feedbackRepository.save(feedback);

        movie.setVotesCount();
        movie.setRateValue();
        movieRepository.save(movie);

        return feedback;
    }
}
