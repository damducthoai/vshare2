package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.binding.PremiumCard;
import vshare.common.binding.UpgradeInfo;
import vshare.common.entity.PremiumCardEntity;

@Controller
@RequestMapping(path = "upgrade")
public class UpgradeController extends BaseController {

    @GetMapping
    String getUpgradeUI(Model model) {
        model.addAttribute("card", new PremiumCardEntity());
        model.addAttribute("premiumSizeData", PremiumCard.UPGRADE_SIZE);
        model.addAttribute("premiumSize", new UpgradeInfo());
        model.addAttribute("premiumData", getPremiumData());
        model.addAttribute("user", getUser());
        return "upgrade";
    }

    @PostMapping(params = "upgrade=point")
    String processUpgrade(Model model, @ModelAttribute("card") PremiumCardEntity card) {
        boolean success = upgradePremium(card.getCardCode());
        model.addAttribute("card", getPremiumCardByCode(card.getCardCode()));
        model.addAttribute("premiumData", getPremiumData());
        return success ? "upgrade_point_success" : "upgrade_point_fail";
    }

    @PostMapping(params = "upgrade=vip")
    String doUpgrage(Model model, @ModelAttribute("premiumSize") UpgradeInfo info) {
        boolean success = upgradePremium(info.getSize());
        return "";
    }

}
