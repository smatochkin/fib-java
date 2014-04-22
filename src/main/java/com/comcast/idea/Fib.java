package com.comcast.idea;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.Integer;

public class Fib extends HttpServlet {

  private int fibonacci(int n) {
    if (n <= 1) { return n; }
    return fibonacci(n - 1) + fibonacci(n-2);
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    int n;

    try {
      n = Integer.parseInt(request.getParameter("n"));
    } catch (Exception e) {
      n = 40;
    }

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    out.println("<h1>Fibonacci</h1>");
    out.println("Fibonacci number " + n + " is " + fibonacci(n));
  }
}
