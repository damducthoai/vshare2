package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "register")
public class RegisterController extends BaseController {
    @GetMapping
    String getRegisterUI() {
        // TODO
        return "register";
    }

    @PostMapping
    String doRegister() {
        // TODO
        return "";
    }
}
