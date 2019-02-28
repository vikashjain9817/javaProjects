package com.capgemini.service;

import java.util.HashMap;

import com.capgemini.beans.Trainer;
import com.capgemini.exception.FeedbackNotFoundException;
import com.capgemini.exception.InvalidRatingException;

public interface FeedbackService {

	void addFeedback(Trainer trainer) throws InvalidRatingException, FeedbackNotFoundException;

	HashMap<Integer, Trainer> getTrainerList(int rating) throws FeedbackNotFoundException;

}