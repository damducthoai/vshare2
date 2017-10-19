package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vshare.common.binding.PremiumCard;
import vshare.common.entity.PremiumCardEntity;

@Controller
@RequestMapping(path = "cards")
public class CardController extends BaseController {
    @Autowired
    PremiumCard premiumCard;

    @PostMapping
    String createCard(Model model, @ModelAttribute("card") PremiumCardEntity card) {
        // TODO
        createPremiumCard(card.getPoint());
        return "redirect:/cards";
    }

    @GetMapping
    String getCreateCardUI(Model model) {
        // TODO
        model.addAttribute("card", new PremiumCardEntity());
        model.addAttribute("type", premiumCard.CARD_TYPES);
        return "create_card";
    }

    @DeleteMapping
    String deleteCard(Model model) {
        return null;
    }
}
