package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController extends BaseController {

    @GetMapping(path = "login")
    String getLoginUI() {
        return "login";
    }
}
