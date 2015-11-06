/*
Copyright Jack Landry and Lexa Grasz 2015
*/


package graszlandry.business;


import java.io.Serializable;
import java.text.NumberFormat;


/**
 *
 * @author Lexa Grasz and Jack Landry
 * The User class creates a user object that stores the input investment amount,
 * interest rate, years compounded, and the future monetary value which includes
 * the initial investment amount in addition to the compounded interest.
 */
public class User implements Serializable {
    
    private double investment;
    private double interest;
    private int years;
    private double futureValue;
    
    public User() {
        investment = 0;
        interest = 0;
        years = 0;
        futureValue = 0;
        
    }
    
   /**
   * Creates a user object that stores the investment and interest value and 
   * the number of years the investment should be compounded
   * @param investment
   *              the input investment value
   * @param interest
   *              the input interest rate
   * @param years
   *              the input number of years to compound the investment
    **/
    
    public User(Double investment, Double interest, int years) {
        this.investment = investment;
        this.interest = interest;
        this.years = years;
    }

    /**
     * @return the investment
     * Getter method for investment double.
     */
    public double getInvestment() {
        return investment;
    }
    
   /**
    * Method that returns the investment amount properly formatted with a
    * dollar sign, commas, and decimals
    * @return the properly formatted investment
    */
    
    public String getInvestmentCurrencyFormat() {
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      String currencyInvestment = currency.format(this.getInvestment());
      return currencyInvestment;
    }

    /**
     * @param investment 
     *              sets the investment value
     */
    public void setInvestment(double investment) {
        this.investment = investment;
    }

    /**
     * @return returns the interest value
     */
    public double getInterest() {
        return interest;
    }

    /**
     * @param interest 
     *          sets the interest value
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return returns the entered number of years
     */
    public int getYears() {
        return years;
    }

    /**
     * @param years 
     *          sets the number of years 
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * @return the futureValue which is the investment + the compounded interest
     */
    public double getFutureValue() {
        return futureValue;
    }

    /**
     * @param futureValue 
     *              sets the future monetary value which is the 
     * investment + the compounded interest
     * 
     */
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }
    
   
    
}
