package vshare.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.binding.ChangepassInfo;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/changepassword")
public class ChangePwdController extends BaseController {
    @GetMapping
    String getChangePasswordUI(Model model) {
        model.addAttribute("info", new ChangepassInfo());
        return "change_pass";
    }

    @PostMapping
    ResponseEntity processChangePassword(@Valid @ModelAttribute("info") ChangepassInfo info, BindingResult result) {
        boolean success = false;
        if (!result.hasErrors()) {
            if (info.getCurrentPassword().equals(getUser().getUserPassword())) {
                if (info.getNewPassword().equals(info.getConfirmNewPassword())) {
                    success = true;
                }
            }
        }
        return success ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
