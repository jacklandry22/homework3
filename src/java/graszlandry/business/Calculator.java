 /*
 * Copyright Jack Landry and Lexa Grasz 2015
 */
package graszlandry.business;

/**
 * @author Lexa Grasz and Jack Landry
 * The Calculator class takes a user object and uses the formula for compounded 
 * interest to determine the total amount of money one will have after interest 
 * is added to their investment. 
 */
public class Calculator {
    
    private Double futureValue;
    private User user;
    
    public Calculator(User user) {
        this.user = user;
    }
    
/**
 * 
 * 
 * @return futureValue the investment + the compounded interest over the given
 * time frame
 * 
 * The calculate method uses the parameter of a User object to get the 
 * investment amount, the interest rate, and the number of years the to compound 
 * interest for. This class returns the future value of the original investment
 * with the addition of the compounded interest. 
 * 
 */
    public Double calculate() {
        Double investment = user.getInvestment();
        Double interest = user.getInterest()/100;
        int years = user.getYears();
        Double a = (1 + interest);
        int b = years;        
        futureValue = investment*Math.pow(a, b);
        
        return futureValue;
    }
    
    /**
     * @return futureValue the investment + the compounded interest over the given
     * time frame
     * This is a getter method for the futureValue double.
     */
    public double getFutureValue() {
        return calculate();
    }
    /**
     * Method returns the integer number of years entered by the user
     * @return the integer number of years entered by the user
     */
    public int getYears() {
        return user.getYears();
    }

    /**
     * @param futureValue 
     *              the investment + the compounded interest over the given
     * time frame
     * This sets the value of the futureValue double.
     */
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }
    
}
