/*Copyright Jack Landry and Lexa Grasz 2015*/

package graszlandry.controllers;

import graszlandry.business.Calculator;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graszlandry.business.User;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;

/**
 * * @author Lexa Grasz and Jack Landry
 * Controls interaction with three jsp pages. Mapped to the /calculate URL. 
 * Two methods, doGet and doPost, are written. 
 * The doGet method calls the doPost method.
 *
 */
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

    


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/index.jsp";
        ServletContext sc = getServletContext();
        
        //Get current action 
        String action = request.getParameter("action");
        
        if (action==null){
            action = "join";
        }
        
        if (action.equals("join")){
            url = "/index.jsp";
        }
       
        else if (action.equals("add")){
        //Get parameters from the request
        String investmentS = request.getParameter("investment");
        Double investment = Double.parseDouble(investmentS);
        String interestS = request.getParameter("interest");
        Double interest = Double.parseDouble(interestS);
        String yearsS = request.getParameter("years");
        int years = Integer.parseInt(yearsS);
        

        
        //Stores data in User object
        HttpSession session = request.getSession();
        User user = new User(investment, interest, years);
        Calculator calculator = new Calculator(user);
        //For loop? No need for Years class
        ArrayList <Calculator> calculators = new ArrayList<Calculator>();
        
       for (int i = 1; i <= user.getYears(); i++) {
           User user2 = new User(investment, interest, i);
        Calculator calculator2 = new Calculator(user2);
       calculators.add(calculator2);
    }
            
            
            url = "/future.jsp";
        
        
        
        session.setAttribute("user", user);
        session.setAttribute("calculator", calculator);
        session.setAttribute("calculators", calculators);
        
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    

}
