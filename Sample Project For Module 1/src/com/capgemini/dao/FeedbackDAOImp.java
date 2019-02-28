package com.capgemini.dao;


import java.util.HashMap;
import java.util.Map;

import com.capgemini.beans.Trainer;
import com.capgemini.exception.FeedbackNotFoundException;
import com.capgemini.exception.InvalidRatingException;
import com.capgemini.util.DBUtil;

public class FeedbackDAOImp implements FeedbackDAO {
	
	HashMap<Integer, Trainer> trainers = DBUtil.feedbackList;
	
	/*
	 * To add the feedback to the hashMap.
	 * 
	 */
	@Override
	public void addFeedback(Trainer trainer) throws FeedbackNotFoundException, InvalidRatingException {
		
		int key = (int)DBUtil.getId();
		
		for (Map.Entry<Integer,Trainer> entry : trainers.entrySet())  {
			if(entry.getKey() == key)
				throw new FeedbackNotFoundException("Dupicate Id exception occured");
		}
		
		if(trainer.getRating() > 5 || trainer.getRating() < 0) {
			throw new InvalidRatingException("invalid rating exception occured");
		}
		
		trainers.put(key, trainer);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.capgemini.dao.FeedbackDAO#getTrainerList(int)
	 */
	@Override
	public HashMap<Integer, Trainer> getTrainerList(int rating) throws FeedbackNotFoundException{
		
		HashMap<Integer, Trainer> ratingTrainers = new  HashMap<Integer, Trainer>();
		
		for (Map.Entry<Integer,Trainer> entry : trainers.entrySet())  {	
			if(entry.getValue().getRating() == rating)
				ratingTrainers.put(entry.getKey(), entry.getValue());
		}
		if(ratingTrainers.isEmpty()) {
			throw new FeedbackNotFoundException("The Given Rating has no tainer");
		}
		return ratingTrainers;
	}
}
