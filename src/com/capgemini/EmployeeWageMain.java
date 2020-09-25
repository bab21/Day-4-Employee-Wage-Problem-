package com.capgemini;
import java.util.*;


public class EmployeeWageMain {
//	public static final int WAGE_PER_HOUR=20;
	public static final int FULL_DAY_HOUR=8;
	public static final int HALF_DAY_HOUR=4;
//	public static final int WORKING_DAYS_PER_MONTH=20;
//	public static final int MAX_WORKING_HOURS=100;
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation");
		
		Random rand=new Random();
		
		//Checking for attendance....
		int prs_abs=rand.nextInt(2);
		
		if(prs_abs==0)
			System.out.println("Absent");
		else System.out.println("Present");
		
		
		int monthly_wage=compute_wage("capgemini",20,20,200);
		
		System.out.println("Wage of employee for the month :"+monthly_wage);
		
		
		
		
		
	}
	public static int compute_wage(String company,int empRatePerHour,int numberOfWorkingDays,int maxHoursPerMonth) {
		
	     int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;
	     Random rand=new Random();
	     //checking if employee is full_time or part_time....
	     int full_part=rand.nextInt(2);
	     
	     
	     while(totalEmpHrs<=maxHoursPerMonth && totalWorkingDays<numberOfWorkingDays) {
	    	 totalWorkingDays++;
	    	
	    	 
	    	 switch(full_part) {
	    	 case 1:
	    		 empHrs=FULL_DAY_HOUR;
	    		 break;
	    	 case 0:
	    		 empHrs=HALF_DAY_HOUR;
	    		 break;
	    	 default:
	    		empHrs=0;	 
	    	 }
	    	 
	    	 totalEmpHrs +=empHrs;
	    	 System.out.println("Day#:"+totalWorkingDays+" Emp Hr: "+empHrs);
	    	 
	    	 
	     }
	     int totalEmpWage=totalEmpHrs*empRatePerHour;
	     System.out.println("Total Emp Wage for Company :"+company +" is :"+totalEmpWage);
	     
	     return totalEmpWage;
	     
	}

}
