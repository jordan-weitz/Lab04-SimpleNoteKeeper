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

            // I had problems getting this code to work because if a null 
//            or a String value was entered the code would exit the try/catch
//              without assinging the values to the attributes so I first took the 
//              values as a string, assigned the attributes and then parsed the string values
//              which then may set off the catch block.
            String firstString = request.getParameter("first_num");
            String secondString = request.getParameter("second_num");
            request.setAttribute("firstNum", firstString);
            request.setAttribute("secondNum", secondString);
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

        }
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request, response);

    }

}
