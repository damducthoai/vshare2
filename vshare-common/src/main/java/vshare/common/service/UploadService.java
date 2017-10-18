package vshare.common.service;

import org.springframework.web.multipart.MultipartFile;
import vshare.common.entity.FileEntity;

public interface UploadService {
    /**
     * process http upload
     *
     * @param multipartFile
     * @return physical file name
     */
    FileEntity httpUpload(MultipartFile multipartFile);
}
