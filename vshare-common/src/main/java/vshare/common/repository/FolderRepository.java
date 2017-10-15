package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshare.common.entity.AuthorityEntity;
import vshare.common.entity.FolderEntity;

import java.util.List;

/**
 * Created by Dell on 10/15/2017.
 */
public interface FolderRepository extends JpaRepository<FolderEntity, Long> {

}
