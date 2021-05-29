/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jweit
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String calc = request.getParameter("calc");
        int firstnum;
        int secondnum;
        
        try {
            
            firstnum = Integer.parseInt(request.getParameter("first_num"));
            secondnum = Integer.parseInt(request.getParameter("second_num"));
            

            if (calc != null && calc.equals("plus")) {
                int result = firstnum + secondnum;
                request.setAttribute("message", "Calculation equals " + result);
            } else if (calc != null && calc.equals("minus")) {
                int result = firstnum - secondnum;
                request.setAttribute("message", "Calculation equals " + result);
            } else if (calc != null && calc.equals("times")) {
                int result = firstnum * secondnum;
                request.setAttribute("message", "Calculation equals " + result);
            } else if (calc != null && calc.equals("mod")) {
                int result = firstnum % secondnum;
                request.setAttribute("message", "Calculation equals " + result);
            } else {
                request.setAttribute("message", "Invalid Entry. Please enter a valid Integer");
                return;
            }
        } catch (Exception e) {
            request.setAttribute("message", "Invalid Entry. Please enter a valid integer");
        } finally {
            request.setAttribute("firstNum", firstnum);
        request.setAttribute("secondNum", secondnum);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);

    }

}
