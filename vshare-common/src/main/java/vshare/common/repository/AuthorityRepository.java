package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vshare.common.entity.AuthorityEntity;
import vshare.common.entity.AuthorityEntityPK;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, AuthorityEntityPK> {
    List<AuthorityEntity> findAllByUserId(long userId);
}
