package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.entity.FileEntity;
import vshare.common.repository.FileRepository;
import vshare.common.service.UniqueStringService;
import vshare.common.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

    UniqueStringService uniqueStringService;
    @Autowired
    FileRepository fileRepository;

    @Override
    public FileEntity httpUpload(MultipartFile multipartFile) {
        FileEntity fileEntity = new FileEntity();
        String physicalName = uniqueStringService.getUniqueString();
        fileEntity.setFileOriginalName(multipartFile.getOriginalFilename());
        fileEntity.setFilePhysicalName(physicalName);
        fileEntity.setFileSize(multipartFile.getSize());
        fileRepository.saveAndFlush(fileEntity);
        FileEntity result = fileRepository.findByFilePhysicalName(physicalName);

        return result;
    }

    @Autowired
    public void setUniqueStringService(UniqueStringService uniqueStringService) {
        this.uniqueStringService = uniqueStringService;
    }
}
