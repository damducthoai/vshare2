package vshare.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vshare.common.binding.PremiumCard;
import vshare.common.entity.PremiumCardEntity;
import vshare.common.entity.PremiumCardLogEntity;
import vshare.common.entity.PremiumDataEntity;
import vshare.common.repository.PremiumCardLogRepository;
import vshare.common.repository.PremiumCardRepository;
import vshare.common.repository.PremiumDataRepository;
import vshare.common.service.PremiumCardManager;
import vshare.common.service.SecurityService;
import vshare.common.service.UniqueStringService;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service("premiumCardManager")
public class PremiumCardManagerImpl implements PremiumCardManager {

    @Resource(name = "uniqueStringService")
    UniqueStringService uniqueStringService;

    @Resource(name = "premiumCardRepository")
    PremiumCardRepository premiumCardRepository;

    @Resource(name = "securityService")
    SecurityService securityService;

    @Resource(name = "premiumCardLogRepository")
    PremiumCardLogRepository premiumCardLogRepository;

    @Resource(name = "premiumCard")
    PremiumCard premiumCard;

    @Resource(name = "premiumDataRepository")
    PremiumDataRepository premiumDataRepository;

    @Override
    public PremiumCardEntity createPremiumCard(long point) {
        PremiumCardEntity card = new PremiumCardEntity();
        card.setCardCode(uniqueStringService.getShortString());
        card.setCardSerial(uniqueStringService.getUniqueString());
        card.setCardStatus(PremiumCard.STATUS_AVAILABLE);
        card.setPoint(point);
        card.setCreated(new Date(Calendar.getInstance().getTime().getTime()));
        premiumCardRepository.save(card);
        return null;
    }

    @Override
    @Transactional
    public boolean upgradePremium(String code) {
        boolean success = false;
        long userId = securityService.getUserId();
        PremiumCardEntity card = premiumCardRepository.findByCardCode(code);
        if (card != null && card.getCardStatus().equals(PremiumCard.STATUS_AVAILABLE)) {

            card.setLastModified(new Date(Calendar.getInstance().getTime().getTime()));
            card.setCardStatus(PremiumCard.STATUS_USED);

            premiumCardRepository.save(card);

            PremiumCardLogEntity log = new PremiumCardLogEntity();
            log.setActived(new Date(Calendar.getInstance().getTime().getTime()));
            log.setCardSerial(card.getCardSerial());
            log.setUserId(userId);

            premiumCardLogRepository.save(log);

            PremiumDataEntity premiumData = premiumDataRepository.findOne(userId);

            if (premiumData == null) {
                premiumData = new PremiumDataEntity();
                premiumData.setUserId(userId);
                premiumData.setPoint(card.getPoint());
            } else {
                long point = card.getPoint() + premiumData.getPoint();
                premiumData.setPoint(point);
            }
            premiumDataRepository.save(premiumData);
            success = true;
        }
        return success;
    }

    @Override
    public boolean upgradePremium(long size) {

        boolean success = false;

        long userId = securityService.getUserId();

        PremiumDataEntity premiumData = premiumDataRepository.findOne(userId);

        if (premiumData != null && premiumData.getPoint() > size) {
            LocalDate localDate;
            if (premiumData.getDueTo() == null) {
                localDate = LocalDate.now().plusDays(size / 1000);
            } else {
                localDate = premiumData.getDueTo().toLocalDate();
                localDate = localDate.plusDays(size / 1000);
            }
            Date dueDate = Date.valueOf(localDate);

            premiumData.setDueTo(dueDate);
            premiumData.setPoint(premiumData.getPoint() - size);
            premiumDataRepository.save(premiumData);

            success = true;
        }
        return success;
    }

    @Override
    public List<PremiumCardEntity> getCards() {
        return premiumCardRepository.findAll();
    }

    @Override
    public PremiumDataEntity getPremiumData() {
        PremiumDataEntity data = premiumDataRepository.findOne(securityService.getUserId());
        return data;
    }
}
