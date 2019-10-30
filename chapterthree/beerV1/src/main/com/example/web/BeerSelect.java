package main.com.example.web;

import main.com.example.model.BeerExpert;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Iterator;
import java.util.List;

public class BeerSelect extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String c = request.getParameter("color");
        BeerExpert inServlet = new BeerExpert();
        List beerCard = inServlet.getBrands(c);
//        PrintWriter out = response.getWriter();
//        out.println("Beer Selection Advice<br>");
//        Iterator iter = beerCard.iterator();
//        while (iter.hasNext()) {
//            out.println("<br>Try this beer " + iter.next());
//        }
        request.setAttribute("styles", beerCard);
        RequestDispatcher view =
                request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}