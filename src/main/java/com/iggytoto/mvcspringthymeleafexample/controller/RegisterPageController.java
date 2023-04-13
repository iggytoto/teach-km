package com.iggytoto.mvcspringthymeleafexample.controller;

import com.iggytoto.mvcspringthymeleafexample.configuration.PageNameConstants;
import com.iggytoto.mvcspringthymeleafexample.model.Account;
import com.iggytoto.mvcspringthymeleafexample.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterPageController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping
    public String registerPage(Model model) {
        model.addAttribute("account", new Account());
        return PageNameConstants.REGISTER;
    }

    @PostMapping
    @Transactional
    public String registerAction(@ModelAttribute("account") Account account) {
        userAccountService.registerNewUser(account);
        return PageNameConstants.REGISTER;
    }
}
