package com.yqz.webapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("SimpleServlet2 Executed");
		out.flush();
		out.close();
	}
}
