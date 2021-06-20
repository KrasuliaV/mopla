package com.cursor.mopla.controller;

import com.cursor.mopla.entities.Feedback;
import com.cursor.mopla.security.JwtUtil;
import com.cursor.mopla.service.FeedbackService;
import com.cursor.mopla.ui.request.FeedbackRequest;
import com.cursor.mopla.ui.response.AuthenticationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final ModelMapper mapper;
    private final JwtUtil jwtUtil;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, ModelMapper mapper, JwtUtil jwtUtil) {
        this.feedbackService = feedbackService;
        this.mapper = mapper;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = "/movie/{movieId}")
    public ResponseEntity<?> create(@PathVariable Long movieId,
                                    @RequestBody final FeedbackRequest feedbackRequest,
                                    @RequestHeader("Authorization") AuthenticationResponse authenticationResponse) {

        Long userId = Long.parseLong(getIdFromHeadersJwt(authenticationResponse));
        final var newFeedback = feedbackService.create(
                mapper.map(feedbackRequest, Feedback.class),
                movieId,
                userId);

        return ResponseEntity.ok(newFeedback);
    }

    private String getIdFromHeadersJwt(AuthenticationResponse authenticationResponse) {
        return jwtUtil.extractUserId(authenticationResponse.getJwt().substring(7));
    }
}
