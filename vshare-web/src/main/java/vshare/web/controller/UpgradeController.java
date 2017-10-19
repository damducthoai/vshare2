package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.entity.PremiumCardEntity;

@Controller
@RequestMapping(path = "upgrade")
public class UpgradeController extends BaseController {
    @GetMapping
    String getUpgradeUI(Model model) {
        model.addAttribute("card", new PremiumCardEntity());
        return "upgrade";
    }

    @PostMapping
    String processUpgrade(Model model, @ModelAttribute("card") PremiumCardEntity card) {
        boolean success = upgradePremium(card.getCardCode());
        return "";
    }

}
