package vshare.common.service;

import vshare.common.entity.PremiumCardEntity;
import vshare.common.entity.PremiumDataEntity;

import java.util.List;

public interface PremiumCardManager {
    PremiumCardEntity createPremiumCard(long point);

    boolean upgradePremium(String code);

    boolean upgradePremium(long size);

    List<PremiumCardEntity> getCards();

    PremiumDataEntity getPremiumData();
}
