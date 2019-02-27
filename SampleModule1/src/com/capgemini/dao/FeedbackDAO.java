package com.capgemini.dao;

import java.util.HashMap;

import com.capgemini.beans.Trainer;

public interface FeedbackDAO {

	void addFeedback(Trainer trainer);

	HashMap<Integer, Trainer> getTrainerList(int rating);

}