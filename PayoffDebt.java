/*
 *PayoffDebt.java
 * Author:  Caleb Odunade
 * Submission Date:  [Submission date here]
 *
 * Purpose: This programs purpose is to calculate Credit Card Pay off by using the input of the 
 * Principal Amount, Annual Interest Rate, Monthly Payment to make an output of the months 
 * left to pay off, the total amount paid, Total Interest Paid, and Overpayment. 
 * 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither 
 * received nor given inappropriate assistance. I have not copied 
 * or modified code from any source other than the course webpage 
 * or the course textbook. I recognize that any unauthorized 
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the 
 * policies of this course. I recognize that my work is based 
 * on an assignment created by the School of Computing 
 * at the University of Georgia. Any publishing or
 * posting of source code for this assignment is strictly 
 * prohibited unless you have written consent from the 
 * School of Computing at the University of Georgia.  
 */
import java.util.Scanner;
public class PayoffDebt {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Principal: \t\t\t");
		double principal = sc.nextDouble();
		sc.nextLine();
		System.out.print("Annual Intrest Rate (%):\t");
		double annualInterestRate = sc.nextDouble();
		sc.nextLine();
		System.out.print("Montly Payment: \t\t");
		double monthlyPayment = sc.nextDouble();
		
		double monthsNeededtoPayoffRaw = ((Math.log(monthlyPayment)- Math.log(monthlyPayment - 
				annualInterestRate/1200 * principal))/ Math.log(annualInterestRate / 1200 +1)); 
		int monthsNeededtoPayoffCeiling = (int) Math.ceil(monthsNeededtoPayoffRaw);
		
		final double TOTAL_AMOUNT_PAID = monthsNeededtoPayoffCeiling*monthlyPayment;
		final double TOTAL_INTREST_PAID = TOTAL_AMOUNT_PAID-principal;
		
		// Set overpayment = totalAmountPaid - monthsNeededtoPayoffRaw * monthlyPayment
		double overpayment =  TOTAL_AMOUNT_PAID-monthsNeededtoPayoffRaw*monthlyPayment; 
		
		System.out.println();
		System.out.println("Months Needed To Pay Off: \t" + monthsNeededtoPayoffCeiling);
		System.out.printf("Total Amount Paid:\t\t" + "$" + "%.2f" , TOTAL_AMOUNT_PAID);
		System.out.printf("\nTotal Interest Paid:\t\t" + "$" + "%.2f" , TOTAL_INTREST_PAID);
		System.out.printf("\nOverpayment:\t\t\t" + "$" + "%.2f" , overpayment);
	}

}
