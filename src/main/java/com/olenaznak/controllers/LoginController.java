package com.olenaznak.controllers;

import com.olenaznak.dao.UserDao;
import com.olenaznak.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.security.RolesAllowed;

@Controller
public class LoginController {

    private UserDao userDao;

    @RequestMapping(value = "/")
    public ModelAndView login(){
        return new ModelAndView("WEB-INF/pages/index");
    }

    @RolesAllowed(value = "ROLE_USER")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView userCheckout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        userDao.addSUser(user);
        return new ModelAndView("home");
    }

    @RolesAllowed(value = "ROLE_ADMIN")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminCheckout() {
        return new ModelAndView("admin");
    }

    @RolesAllowed(value = "ROLE_GUARD")
    @RequestMapping(value = "/guard", method = RequestMethod.GET)
    public ModelAndView guardCheckout() {
        return new ModelAndView("guard");
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
