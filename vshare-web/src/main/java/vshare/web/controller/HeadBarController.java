package vshare.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vshare.common.entity.ServerEntity;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "user")
public class HeadBarController extends BaseController {
    @GetMapping
    String getUserPresent(Model model) {
        model.addAttribute("user", getUser());
        return "menuHead";

    }
}
