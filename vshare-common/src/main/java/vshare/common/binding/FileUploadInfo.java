package vshare.common.binding;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class FileUploadInfo {
    @NotNull
    private MultipartFile file;
    private Long parrentId;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getParrentId() {
        return parrentId;
    }

    public void setParrentId(Long parrentId) {
        this.parrentId = parrentId;
    }
}
