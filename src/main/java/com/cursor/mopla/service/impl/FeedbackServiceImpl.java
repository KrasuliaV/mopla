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
        feedback.setUser(userRepository.getById(userId));
        feedback.setMovie(movieRepository.getById(userId));
        return feedbackRepository.save(feedback);
    }
}
