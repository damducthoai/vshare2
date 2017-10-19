package vshare.common.service;

import vshare.common.entity.PremiumCardEntity;

public interface PremiumCardManager {
    PremiumCardEntity createPremiumCard(long point);

    boolean upgradePremium(String code);
}
