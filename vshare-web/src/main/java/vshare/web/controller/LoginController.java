package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController extends BaseController {

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
