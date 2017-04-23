package com.kim.web;

import com.kim.domain.User;
import com.kim.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    SessionRegistry sessionRegistry;

    @RequestMapping("/login")
    ModelAndView login(HttpSession session) {
        if(sessionRegistry.getSessionInformation(session.getId()) != null)
            return new ModelAndView("index");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ModelAndView loginProcess(User user, HttpSession session) {
        session.setAttribute("id", user.getId());
        sessionRegistry.registerNewSession(session.getId(), session);
        System.out.println(session.getId());
//        List<Object> s = sessionRegistry.getAllPrincipals();
//        List<Object> result = s.stream().map(list->sessionRegistry.getAllSessions(list, false)).collect(Collectors.toList());

        return new ModelAndView("index");
    }

    @RequestMapping("/user")
    String user() {
        loginService.insert("kim", "0000");
        return "create";
    }
}