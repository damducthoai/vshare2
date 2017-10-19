package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vshare.common.entity.PremiumDataEntity;

@Repository("premiumDataRepository")
public interface PremiumDataRepository extends JpaRepository<PremiumDataEntity, Long> {
}
