package com.capgemini.bl;

import java.util.Scanner;

import com.capgemini.beans.Course;
import com.capgemini.beans.Student;

public class StudentSchedular {
	
	private static Scanner sc = new Scanner(System.in);
	private Student[] students = new Student[10];
	private Course[] courses = new Course[10];
	private int counter;
	private int courseCounter;
	
	public String updateroll(int rollNumber)
	{
		for(int  i = 0; i < counter; i++)
		{
			if(students[i].getRollno() == rollNumber)
			{
				System.out.println("enter new rollnumber");
				int r = sc.nextInt();
				students[i].setRollno(r);
			}
		}
		return "student roll number updated successfully";
	}
	
	public String addStudent(int rollNumber,String name)
	{
		if(isduplicate(rollNumber))
		{
			students[counter++] = new Student(rollNumber,name);
			return "Student added successfully";
		}
		else {
			return "This rollNumber is already Registered please add another";
		}
		
	}
	
	private boolean isduplicate(int rollNumber) {
		for(int i = 0; i < counter; i++)
		{
			if(students[i].getRollno() == rollNumber)
				return false;
		}
		return true;
	}

	public String showAllStudents()
	{
		String s  = "";
		for(int i = 0; i < counter; i++)
		{
			s = s + students[i].getRollno();
			s = s + ",";
			s = s + students[i].getName();
			s = s + "|";
		}
		return s;
	}
	
	public String showbyroll(int rollnumber)
	{
		String s = "";
		for(int i = 0; i < counter; i++)
		{
			if(students[i].getRollno() == rollnumber)
			{
				s = s + students[i].getRollno();
				s = s + ",";
				s = s + students[i].getName();
				s = s + ".";
			}
		}
		return s;
	}
	
	public String addcourse(String name, int courseid)
	{
		courses[courseCounter++] = new Course(courseid, name);
		return "course added successfully";
	}
	
	public String showcourse()
	{
		String s = "";
		for(int i = 0; i < courseCounter; i++)
		{
			s = s + courses[i].getCourseid();
			s = s + ",";
			s = s + courses[i].getCoursename();
			s = s + ".";
		}
		return s;
	}

	public String addStudentToCourses(int n, int ch) {
		
		for(int i = 0; i < counter; i++)
		{
			if(students[i].getRollno() == ch)
			{
				for(int j = 0; j < n; j++)
				{
					
				}
			}
		}
		return null;
	}
}
