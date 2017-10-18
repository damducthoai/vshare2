package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import vshare.common.entity.ServerEntity;

@Service("serverRepository")
public interface ServerRepository extends JpaRepository<ServerEntity, String> {
}
