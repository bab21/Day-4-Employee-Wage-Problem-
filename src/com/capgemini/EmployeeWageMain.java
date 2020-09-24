package com.capgemini;
import java.util.*;


public class EmployeeWageMain {
	public static final int WAGE_PER_HOUR=20;
	public static final int FULL_DAY_HOUR=8;
	public static final int HALF_DAY_HOUR=8;
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation");
		
		Random rand=new Random();
		
		//Checking for attendance....
		int prs_abs=rand.nextInt(2);
		
		if(prs_abs==0)
			System.out.println("Absent");
		else System.out.println("Present");
		
		int full_part=rand.nextInt(2);
		int daily_wage=0;
		switch(full_part) {
		case 1:daily_wage=WAGE_PER_HOUR*FULL_DAY_HOUR;
			   break;
		case 2:daily_wage=WAGE_PER_HOUR*HALF_DAY_HOUR;
				break;
		default:System.out.print("nothing");
		
		}
		
		
		System.out.println("Wage of employee for the day :"+daily_wage);
		
		
		
		
		
	}

}
