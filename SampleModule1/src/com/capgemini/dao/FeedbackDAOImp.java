package com.capgemini.dao;


import java.util.HashMap;
import java.util.Map;

import com.capgemini.beans.Trainer;
import com.capgemini.util.DBUtil;

public class FeedbackDAOImp implements FeedbackDAO {
	
	HashMap<Integer, Trainer> trainers = new  HashMap<Integer, Trainer>();
	
	/*
	 * To add the feedback to the hashMap.
	 * 
	 */
	@Override
	public void addFeedback(Trainer trainer) {
		
		int key = (int)DBUtil.getId();
		trainers.put(key, trainer);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.capgemini.dao.FeedbackDAO#getTrainerList(int)
	 */
	@Override
	public HashMap<Integer, Trainer> getTrainerList(int rating){
		
		HashMap<Integer, Trainer> ratingTrainers = new  HashMap<Integer, Trainer>();
		
		for (Map.Entry<Integer,Trainer> entry : trainers.entrySet())  {	
			if(entry.getValue().getRating() == rating)
				ratingTrainers.put(entry.getKey(), entry.getValue());
		}
		return ratingTrainers;
	}
}
