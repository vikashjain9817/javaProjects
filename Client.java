package com.capgemini.view;

import java.util.Scanner;

import com.capgemini.bl.StudentSchedular;

public class Client {

	private static Scanner sc = new Scanner(System.in);
	private static StudentSchedular std = new StudentSchedular();
	
	public static void main(String[] args) {
		
		menu();
	}

	private static void menu() {
		
		int choice;
		while(true)
		{
			System.out.println("1 for add new student");
			System.out.println("2 for show all the students");
			System.out.println("3 for update  the rollnumber of students");
			System.out.println("4 for show details by rollnumber");
			System.out.println("5 for add new course");
			System.out.println("6 for show all the course");
			System.out.println("7 for add the student to the course");
			System.out.println("8 for exit");
			
			System.out.println("enter choice");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: addstudent();
					break;
			case 2: showstudents();
					break;
			case 3: updaterollnumber();
					break;
			case 4: showbyRollnumber();
					break;
			case 5: addCourses();
					break;
			case 6: showCourses();
					break;
			case 7: addStudentToCourse();
					break;
			case 8:System.exit(0);
			default:System.out.println("wrong choice");
					break;
			}
		}
		
		
	}

	private static void addStudentToCourse() {
		System.out.println("enter roll number of student in which you want to add course");
		int ch = sc.nextInt();
		System.out.println("enter the number of courses");
		int n = sc.nextInt();
		System.out.println(std.addStudentToCourses(n, ch));
	}

	private static void showCourses() {
		System.out.println(std.showcourse());
	}

	private static void addCourses() {
		System.out.println("enter course id");
		int courseid = sc.nextInt();
		System.out.println("enter course name");
		String coursename = sc.next();
		System.out.println(std.addcourse(coursename, courseid));
	}

	private static void showbyRollnumber() {
		System.out.println("enter roll number");
		int rollnumber = sc.nextInt();
		System.out.println(std.showbyroll(rollnumber));
	}

	private static void updaterollnumber() {
		System.out.println("enter rollnumber of the student which you want to update");
		int rollNumber = sc.nextInt();
		System.out.println(std.updateroll(rollNumber));
	}

	private static void showstudents() {
		System.out.println(std.showAllStudents());
		
	}

	private static void addstudent() {
		
		System.out.println("enter roll number");
		int rollNumber = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		String c = std.addStudent(rollNumber, name);
		System.out.println(c);
		
	}
}