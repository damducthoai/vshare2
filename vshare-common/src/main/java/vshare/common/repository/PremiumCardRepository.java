package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vshare.common.entity.PremiumCardEntity;

@Repository("premiumCardRepository")
public interface PremiumCardRepository extends JpaRepository<PremiumCardEntity, String> {
    PremiumCardEntity findByCardCode(String code);
}
