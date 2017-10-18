package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "home")
public class HomeController extends BaseController {

    @GetMapping
    String getHomeUI(Model model) {
        prepareHomeModel(model, null);
        return "home";
    }

    @GetMapping(value = "/{folderId}")
    String getChildFolder(Model model, @PathVariable("folderId") Long curFolderId) {
        prepareHomeModel(model, curFolderId);
        return "home";
    }
}
