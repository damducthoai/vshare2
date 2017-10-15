package vshare.common.dao.impl;

import vshare.common.dao.FileDAO;
import vshare.common.entity.FileEntity;
import vshare.common.repository.FileRepository;

/**
 * Created by Dell on 10/15/2017.
 */
public class FileDAOImpl implements FileDAO {
    FileRepository fileRepository;
    @Override
    public boolean addFile(FileEntity fileEntity) {
        fileRepository.save(fileEntity);
        return true;
    }

    @Override
    public boolean updateFile(FileEntity fileEntity) {
        fileRepository.save(fileEntity);
        return true;
    }

    @Override
    public boolean deleteFile(FileEntity fileEntity) {
        fileRepository.delete(fileEntity);
        return true;
    }

    @Override
    public FileEntity findFileById(long fileId) {

        return fileRepository.findOne(fileId);
    }

    @Override
    public boolean deleteFileById(long fileId) {
        fileRepository.delete(fileId);
        return true;
    }
    public void setFileRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
}
