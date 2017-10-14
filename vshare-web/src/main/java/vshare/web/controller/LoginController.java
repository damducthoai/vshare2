package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vshare.common.service.Biz;

@Controller
public class LoginController {
    @Autowired
    Biz biz;

    @GetMapping(path = "login")
    String getLoginUI() {
        return "login";
    }

    @GetMapping(path = "welcome")
    @ResponseBody
    String welcome() {
        return "welcome to web".concat(biz.getLoggedInAuthorities().toString());
    }
}
