package com.capgemini.test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.HashMap;
import org.junit.Test;

import com.capgemini.beans.Trainer;
import com.capgemini.exception.FeedbackNotFoundException;
import com.capgemini.exception.InvalidRatingException;
import com.capgemini.service.FeedbackService;
import com.capgemini.service.FeedbackServiceImp;

public class MainTest {

	static FeedbackService productService = new FeedbackServiceImp();
	
	/*
	 * When Invalid rating is passed
	 * then this test case will be green.
	 */
	@Test(expected = com.capgemini.exception.InvalidRatingException.class)
	public void WhenTheInvalidFeedbackIsPassedThenThrowAnError() throws InvalidRatingException, FeedbackNotFoundException {
		
		Trainer trainer = new Trainer("Smitha","Java",LocalDate.of(2000, 04, 12),LocalDate.of(2000, 04, 11),8);
		productService.addFeedback(trainer);
	}
	/*
	 * When all the information is 
	 * valid then add trainer successfully.
	 */
	
	@Test
	public void WhenAllTheInformationIsValidThenAddedSuccessfully() throws InvalidRatingException, FeedbackNotFoundException {
		
		Trainer trainer = new Trainer("vikash","c",LocalDate.of(2000, 04, 12),LocalDate.of(2000, 04, 11),5);
		productService.addFeedback(trainer);
		HashMap<Integer, Trainer> details = productService.getTrainerList(5);
		assertEquals(true, details.containsValue(trainer));
	}
	
	/*
	 * When the Given rating has no trainer
	 * then this test case will be green.
	 */
	@Test(expected = com.capgemini.exception.FeedbackNotFoundException.class)
	public void WhenTheGivenFeedbackNotPresentInTheCollectionThenThrowAnException() throws FeedbackNotFoundException {
		
			productService.getTrainerList(2);
		
	}
	
	/*
	 * When the given rating 
	 * trainer present then this test case will be green.
	 */
	@Test
	public void WhenTheGivenFeedbackIsPresentInTheCollectionThenReturnSuccessfully() throws FeedbackNotFoundException, InvalidRatingException {
		
		Trainer trainer = new Trainer("vikash","c",LocalDate.of(2000, 04, 12),LocalDate.of(2000, 04, 11),5);
		productService.addFeedback(trainer);
		HashMap<Integer, Trainer> details = productService.getTrainerList(5);
		assertEquals(true, details.containsValue(trainer));
	}
	
	
}