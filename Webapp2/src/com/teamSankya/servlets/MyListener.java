package com.teamSankya.servlets;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("destroyed");
		
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("for every request");
		
		
	}

}
