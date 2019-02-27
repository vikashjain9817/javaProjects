package com.capgemini.service;

import java.util.HashMap;

import com.capgemini.beans.Trainer;
import com.capgemini.dao.FeedbackDAO;
import com.capgemini.dao.FeedbackDAOImp;
import com.capgemini.exception.InvalidRatingException;

public class FeedbackServiceImp implements FeedbackService {

	static FeedbackDAO feedbackDAO = new FeedbackDAOImp();
	
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.FeedbackService#addFeedback(com.capgemini.beans.Trainer)
	 */
	@Override
	public void addFeedback(Trainer trainer) throws InvalidRatingException {
		
		if(trainer.getRating() > 5 || trainer.getRating() < 0) {
			
			throw new InvalidRatingException("invalid rating exception occured");
		}
		
		feedbackDAO.addFeedback(trainer);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.FeedbackService#getTrainerList()
	 */
	@Override
	public HashMap<Integer,Trainer> getTrainerList(int rating){
		
		return(feedbackDAO.getTrainerList(rating));
		
	}
}
