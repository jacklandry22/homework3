/*
 * Copyright Jack Landry and Lexa Grasz 2015
 */
package graszlandry.tags;

import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Lexa Grasz and Jack Landry
 * currencyFormatTag formats any number, specifically the input investment and 
 * the future value in the proper currency format with commas, decimals, and 
 * dollar signs.
 */

public class currencyFormatTag extends TagSupport {
  private double investment;
 
  /**
   * Sets the properly formatted investment number
   * @param investment 
   *                input investment by the user properly formatted
   */
  
  public void setInvestment(double investment){
    this.investment = investment;
  }

  
  /**
   * doStartTag method formats currency numbers correctly
   * @return SKIP_BODY
   * @throws JspException 
   */
  @Override
  public int doStartTag() throws JspException{
    
     NumberFormat currency = NumberFormat.getCurrencyInstance();
     String total = currency.format(investment);
    
        try{
          JspWriter out = pageContext.getOut();
          out.print(total);
          
        }catch(IOException ioe){
          System.out.println(ioe);
        }
        return SKIP_BODY;  
  }

 
  /**
   * Gets the properly formatted investment
   * @return the investment
   * 
   */
  public double getInvestment() {
    return investment;
  }

  
  
}
