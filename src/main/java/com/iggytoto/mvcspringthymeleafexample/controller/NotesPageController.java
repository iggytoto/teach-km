package com.iggytoto.mvcspringthymeleafexample.controller;

import com.iggytoto.mvcspringthymeleafexample.configuration.PageNameConstants;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PageNameConstants.NOTES)
public class NotesPageController {

    @GetMapping
    public String notesPage(Authentication auth) {
        return PageNameConstants.NOTES;
    }
}
