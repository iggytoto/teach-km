package com.iggytoto.mvcspringthymeleafexample.controller;

import com.iggytoto.mvcspringthymeleafexample.configuration.PageNameConstants;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PageNameConstants.LOGIN)
public class LoginPageController {

    @GetMapping()
    public String loginPage(Authentication auth) {
        return PageNameConstants.LOGIN;
    }
}
