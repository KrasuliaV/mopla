package com.cursor.mopla.service;

import com.cursor.mopla.entities.Feedback;

public interface FeedbackService {

    Feedback create(Feedback feedback, Long movieId, Long userId);
}
