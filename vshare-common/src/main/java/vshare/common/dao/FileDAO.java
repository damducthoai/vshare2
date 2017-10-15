package vshare.common.dao;

import vshare.common.entity.FileEntity;

/**
 * Created by Dell on 10/15/2017.
 */
public interface FileDAO {

    FileEntity addFile(FileEntity fileEntity);

    boolean updateFile(FileEntity fileEntity);

    boolean deleteFile(FileEntity fileEntity);

    FileEntity findFileById(long fileId);

    boolean deleteFileById(long fileId);
}
