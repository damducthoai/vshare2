package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.binding.RegisterInfo;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "registration")
public class RegisterController extends BaseController {

    @GetMapping
    private String getRegisterUI(Model model) {
        model.addAttribute("user", getRegisterModel());
        return "register";
    }

    @PostMapping
    String doRegister(@Valid @ModelAttribute("user") RegisterInfo info, BindingResult result) {
        String view = "login";
        if (result.hasErrors()) {
            view = "registration";
        } else {
            if (!createAccount(info).isSuccess()) view = "registration";
        }
        return "redirect:/" + view;
    }
}
