package com.capgemini.dao;

import java.util.HashMap;

import com.capgemini.beans.Trainer;
import com.capgemini.exception.FeedbackNotFoundException;
import com.capgemini.exception.InvalidRatingException;

public interface FeedbackDAO {

	void addFeedback(Trainer trainer) throws FeedbackNotFoundException, InvalidRatingException;

	HashMap<Integer, Trainer> getTrainerList(int rating) throws FeedbackNotFoundException;

}