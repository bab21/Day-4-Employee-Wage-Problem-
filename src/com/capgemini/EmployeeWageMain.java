package com.capgemini;
import java.util.*;


public class EmployeeWageMain {
//	public static final int WAGE_PER_HOUR=20;
	public static final int FULL_DAY_HOUR=8;
	public static final int HALF_DAY_HOUR=4;
//	public static final int WORKING_DAYS_PER_MONTH=20;
//	public static final int MAX_WORKING_HOURS=100;
	
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmployeeWageMain(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation");
		
		Random rand=new Random();
		
		//Checking for attendance....
		int prs_abs=rand.nextInt(2);
		
		if(prs_abs==0)
			System.out.println("Absent");
		else System.out.println("Present");
		
		EmployeeWageMain object=new EmployeeWageMain("capgemini",20,2,10);
		
		object.compute_wage();
		
		
		System.out.println(object);
		
		
		
		
		
	}
	public  void compute_wage() {
		
	     int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;
	     Random rand=new Random();
	     //checking if employee is full_time or part_time....
	     int full_part=rand.nextInt(2);
	     
	     
	     while(totalEmpHrs<=maxHoursPerMonth && totalWorkingDays<numOfWorkingDays) {
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
	     totalEmpWage=totalEmpHrs*empRatePerHour;
	     System.out.println("Total Emp Wage for Company :"+company +" is :"+totalEmpWage);
	     
	    
	     
	}
	public String toString() {
		return "Total Emp Wage for Company:"+company +" is : "+totalEmpWage;
		
	}

}
