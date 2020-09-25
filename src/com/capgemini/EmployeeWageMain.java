package com.capgemini;
import java.util.*;


public class EmployeeWageMain implements IComputeEmpWage {
//	public static final int WAGE_PER_HOUR=20;
	public static final int FULL_DAY_HOUR=8;
	public static final int HALF_DAY_HOUR=4;
//	public static final int WORKING_DAYS_PER_MONTH=20;
//	public static final int MAX_WORKING_HOURS=100;
	
	private int numOfCompany=0;
	private CompanyEmpWage[] companyEmpWageArray;
	public EmployeeWageMain() {
		companyEmpWageArray=new CompanyEmpWage[6];
	}
	
	public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
		companyEmpWageArray[numOfCompany]=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		numOfCompany++;
	}
	
	public  void computeEmpWage() {
		for (int i =0;i<numOfCompany;i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	public  int computeEmpWage(CompanyEmpWage object) {
		
	     int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;
	     Random rand=new Random();
	     //checking if employee is full_time or part_time....
	     int full_part=rand.nextInt(2);
	     
	     
	     while(totalEmpHrs<=object.maxHoursPerMonth && totalWorkingDays<object.numOfWorkingDays) {
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
	     int totalEmpWage=totalEmpHrs*object.empRatePerHour;
	     System.out.println("Total Emp Wage for Company :"+object.company +" is :"+totalEmpWage);
	     return totalEmpWage;
	    
	     
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation");
		
		Random rand=new Random();
		
		//Checking for attendance....
		int prs_abs=rand.nextInt(2);
		
		if(prs_abs==0)
			System.out.println("Absent");
		else System.out.println("Present");
		
		EmployeeWageMain mainobject=new EmployeeWageMain();
		
		mainobject.addCompanyEmpWage("google", 20, 2, 20);
		mainobject.addCompanyEmpWage("deshaw", 50, 2, 60);
		
		mainobject.computeEmpWage();
	}
	

}
