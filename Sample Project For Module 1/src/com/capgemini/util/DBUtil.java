package com.capgemini.util;

import java.time.LocalDate;
import java.util.HashMap;

import com.capgemini.beans.Trainer;

public class DBUtil {
	
	public static HashMap<Integer,Trainer> feedbackList=new HashMap<>();
	
	public static double getId() {
		return Math.random()*1000;
	}
	
	static{
		feedbackList.put(41,new Trainer("Smitha","Java",LocalDate.of(2000, 04, 12),LocalDate.of(2000, 04, 11),5));
		feedbackList.put(42,new Trainer("Smitha","Java",LocalDate.of(2000, 04, 12),LocalDate.of(2000, 04, 11),4));
		feedbackList.put(43,new Trainer("Smitha","Java",LocalDate.of(2000, 04, 12),LocalDate.of(2000, 04, 11),3));
	}
	
}
