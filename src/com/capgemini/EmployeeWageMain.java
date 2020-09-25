package com.capgemini;
import java.util.*;


public class EmployeeWageMain implements IComputeEmpWage {
//	public static final int WAGE_PER_HOUR=20;
	public static final int FULL_DAY_HOUR=8;
	public static final int HALF_DAY_HOUR=4;
//	public static final int WORKING_DAYS_PER_MONTH=20;
//	public static final int MAX_WORKING_HOURS=100;
	
	private int numOfCompany=0;
//	private int daily_wage;
	private ArrayList<CompanyEmpWage> companyEmpWageArray;
	
//	public void compute_daily_wage(int emp_type) {
//		int ans=0;
//		
//		
//		int emphrs=0;
//		if(emp_type==0)
//			emphrs=4;
//		else emphrs=8;
//		
//		for(int i=0;i<numOfCompany;i++) {
//			ans=ans+companyEmpWageArray.get(i).empRatePerHour*emphrs;
//		}
//		daily_wage=ans;
//		
//	}
//	public int total_wage_of_company(int company_num) {
//		
//		return companyEmpWageArray.get(company_num).totalEmpWage;
//		
//	}
	
	public EmployeeWageMain() {
		companyEmpWageArray=new ArrayList<CompanyEmpWage>();
	}
	
	public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
		companyEmpWageArray.add(new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth));
		numOfCompany++;
	}
	
	public void computeEmpWage(int emptype) {
		for (int i =0;i<numOfCompany;i++) {
			companyEmpWageArray.get(i).setTotalEmpWage(this.computeEmpWage(companyEmpWageArray.get(i),emptype));
			System.out.println(companyEmpWageArray.get(i));
		}
	}
	public  int computeEmpWage(CompanyEmpWage object,int emptype) {
		
	     int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;
	     
	     
	     while(totalEmpHrs<=object.maxHoursPerMonth && totalWorkingDays<object.numOfWorkingDays) {
	    	 totalWorkingDays++;
	    	
	    	 
	    	 switch(emptype) {
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
		
	     //checking if employee is full_time or part_time....
	     int full_part=rand.nextInt(2);
	     
		
		//Checking for attendance....
		int prs_abs=rand.nextInt(2);
		
		if(prs_abs==0)
			System.out.println("Absent");
		else System.out.println("Present");
		
		EmployeeWageMain mainobject=new EmployeeWageMain();
		
		mainobject.addCompanyEmpWage("google", 20, 2, 20);
//		mainobject.compute_daily_wage(full_part);
//		System.out.println("Employee Daily wage "+mainobject.daily_wage);
		
		mainobject.addCompanyEmpWage("deshaw", 50, 2, 60);
		mainobject.computeEmpWage(full_part);
		
		int company_num=1;
//		int total_wage_of_the_company=mainobject.total_wage_of_company(company_num);
//		System.out.println("Total wage for company number "+(company_num+1)+" is "+total_wage_of_the_company);
		
		
		
		
	}
	

}
