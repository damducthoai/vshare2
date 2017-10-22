package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.binding.ChangepassInfo;

@Controller
@RequestMapping(path = "/changepassword")
public class ChangePwdController extends BaseController{
    @GetMapping
    String getChangePasswordUI(Model model) {
        model.addAttribute("info", new ChangepassInfo());
        return "change_pass";
    }

    @PostMapping
    String processChangePassword(@ModelAttribute("info") ChangepassInfo info) {

        return "redirect:/home";
    }
}
