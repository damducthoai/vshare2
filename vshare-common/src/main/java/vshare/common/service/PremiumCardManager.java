package vshare.common.service;

import vshare.common.entity.PremiumCardEntity;
import vshare.common.entity.PremiumDataEntity;

public interface PremiumCardManager {
    PremiumCardEntity createPremiumCard(long point);

    boolean upgradePremium(String code);

    boolean upgradePremium(long size);

    PremiumDataEntity getPremiumData();
}
