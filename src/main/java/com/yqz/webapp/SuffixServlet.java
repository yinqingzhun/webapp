package com.yqz.webapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SuffixServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("SuffixServlet Executed");
		out.flush();
		out.close();
	}
}
