/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author lexagrasz
 */
public class currencyFormatTag extends TagSupport {
  private double investment;
 
  
  public void setInvestment(double investment){
    this.investment = investment;
  }

  
  
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
   * @return the investment
   */
  public double getInvestment() {
    return investment;
  }

  
  
}
