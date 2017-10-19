package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vshare.common.entity.PremiumCardLogEntity;

@Repository("premiumCardLogRepository")
public interface PremiumCardLogRepository extends JpaRepository<PremiumCardLogEntity, String> {
}
