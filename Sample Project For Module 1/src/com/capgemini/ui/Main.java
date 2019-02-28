package com.capgemini.ui;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.beans.Trainer;
import com.capgemini.exception.InvalidRatingException;
import com.capgemini.service.FeedbackService;
import com.capgemini.service.FeedbackServiceImp;

public class Main {

	/*
	 * create scanner class object for taking input from the user.
	 */
	static Scanner sc = new Scanner(System.in);
	
	/*
	 * create the object of product service class to call the method 
	 * to find out the product.
	 */
	static FeedbackService productService = new FeedbackServiceImp();
	
	/*
	 * main method
	 */
	public static void main(String[] args) throws InvalidRatingException {
		
		/*
		 * Menu bar to users.
		 */
		while(true)
		{
			System.out.println("1) Enter Details");
			System.out.println("2) Display the details of trainer by feedback rating");
			System.out.println("3) Exit");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: addDetails();break;
			case 2: getDetails();break;
			case 3: System.exit(0);
			default: System.out.println("Wrong choice!");break;
			}
		}
		

	}

	/*
	 * 
	 * This Method takes the details of the feedback and save it to the hashmap.
	 */
	private static void addDetails() throws InvalidRatingException {
		
		System.out.println("Enter Trainer Name");
		sc.nextLine();
		String trainerName = sc.nextLine();
		
		System.out.println("Enter Course Name");
		String courseName = sc.nextLine();
		
		System.out.println("Enter  start Date");
		/*
		 * Starting date
		 */
		System.out.println("enter day");
		int startDay = sc.nextInt();
		System.out.println("enter month");
		int startMonth = sc.nextInt();
		System.out.println("enter year");
		int startYear = sc.nextInt();
		/*
		 * Ending date.
		 */
		System.out.println("Enter  End Date");
		System.out.println("enter day");
		int endDay = sc.nextInt();
		System.out.println("enter month");
		int endMonth = sc.nextInt();
		System.out.println("enter year");
		int endYear = sc.nextInt();
		
		System.out.println("Enter feedback rating");
		int feedback = sc.nextInt();
		
		/*
		 * create the localDate objects to store in Trainer objects.
		 */
		LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
		LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
		
		/*
		 * create the object of trainer class.
		 */
		Trainer trainer = new Trainer(trainerName, courseName, startDate, endDate, feedback);
		
		/*
		 * calling the method of service class to add new trainer feedback.
		 */
		try {
		productService.addFeedback(trainer);
		System.out.println("Trainer Feedback Added Successfully");
		System.out.println("______________________________________________________________________________________");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("______________________________________________________________________________________");
		}
		
	}
	
	/*
	 * This Method will return all the details of the user
	 * of the given feedback rating.
	 */
	private static void getDetails() {
		
		System.out.println("enter Rating");
		int rating = sc.nextInt();
		try {
			HashMap<Integer, Trainer> details = productService.getTrainerList(rating);
			int i = 1;
			for (Map.Entry<Integer,Trainer> entry : details.entrySet())  {	
				System.out.println(i +" Trainer is: ");
				System.out.println("___________________________________________________________________________________________");
				System.out.println("Name is: "+entry.getValue().getName());
				System.out.println("Course Name is: "+entry.getValue().getCourseName());
				System.out.println("Starting Date is: "+entry.getValue().getStartDate());
				System.out.println("Ending Date is: "+entry.getValue().getEndDate());
				System.out.println("Rating is: "+entry.getValue().getRating());
				System.out.println("___________________________________________________________________________________________");
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("___________________________________________________________________________________________");
			}
	}
}
