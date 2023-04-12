package com.iggytoto.mvcspringthymeleafexample.controller;

import com.iggytoto.mvcspringthymeleafexample.configuration.PageNameConstants;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PageNameConstants.LOGIN)
public class LoginPageController {

    @GetMapping()
    public String loginPage(Authentication auth) {
        if (auth != null) {
            return PageNameConstants.NOTES;
        }
        return PageNameConstants.LOGIN;
    }

    @PostMapping
    @Transactional
    public String loginAction(Authentication auth) {
        if (auth == null) {
            return PageNameConstants.LOGIN;
        }
        return PageNameConstants.NOTES;
    }
}
