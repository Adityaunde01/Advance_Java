package com.crudrest.dayEleven.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

public class AuthCheck {

	public static void setAuth(HttpSession session, String userObj) {
        session.setAttribute("userObj", userObj);
    }

    public static boolean isAuth(HttpSession session) {
        return session.getAttribute("userObj") != null;
    }
	
	

}
