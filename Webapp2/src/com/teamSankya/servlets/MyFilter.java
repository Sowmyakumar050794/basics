package com.teamSankya.servlets;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;



public class MyFilter implements Filter{

	public void destroy() {
		System.out.println("destroyed");
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("for every request by filter");
		if(true)
		{
			arg2.doFilter(arg0, arg1);
		  
		}
		else
		{
			HttpServletResponse response=(HttpServletResponse)arg1;
			response.sendRedirect("www.google.com");
		}
	}

	public void init(FilterConfig args) throws ServletException {
		System.out.println("initialized");
		
	}

}
