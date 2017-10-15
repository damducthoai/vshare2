package vshare.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "file", schema = "vshare", catalog = "")
public class FileEntity {
    private long fileId;
    private String fileOriginalName;
    private String filePhysicalName;
    private String fileAddress;
    private Long storageId;
    private Long folderId;
    private String privacy;
    private String status;
    private Long fileSize;

    @Id
    @Column(name = "file_id", nullable = false)
    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "file_original_name", nullable = true, length = 250)
    public String getFileOriginalName() {
        return fileOriginalName;
    }

    public void setFileOriginalName(String fileOriginalName) {
        this.fileOriginalName = fileOriginalName;
    }

    @Basic
    @Column(name = "file_physical_name", nullable = true, length = 250)
    public String getFilePhysicalName() {
        return filePhysicalName;
    }

    public void setFilePhysicalName(String filePhysicalName) {
        this.filePhysicalName = filePhysicalName;
    }

    @Basic
    @Column(name = "file_address", nullable = true, length = 250)
    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    @Basic
    @Column(name = "storage_id", nullable = true)
    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    @Basic
    @Column(name = "folder_id", nullable = true)
    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    @Basic
    @Column(name = "privacy", nullable = true, length = 250)
    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 250)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "file_size", nullable = true)
    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEntity that = (FileEntity) o;

        if (fileId != that.fileId) return false;
        if (fileOriginalName != null ? !fileOriginalName.equals(that.fileOriginalName) : that.fileOriginalName != null)
            return false;
        if (filePhysicalName != null ? !filePhysicalName.equals(that.filePhysicalName) : that.filePhysicalName != null)
            return false;
        if (fileAddress != null ? !fileAddress.equals(that.fileAddress) : that.fileAddress != null) return false;
        if (storageId != null ? !storageId.equals(that.storageId) : that.storageId != null) return false;
        if (folderId != null ? !folderId.equals(that.folderId) : that.folderId != null) return false;
        if (privacy != null ? !privacy.equals(that.privacy) : that.privacy != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (fileSize != null ? !fileSize.equals(that.fileSize) : that.fileSize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (fileId ^ (fileId >>> 32));
        result = 31 * result + (fileOriginalName != null ? fileOriginalName.hashCode() : 0);
        result = 31 * result + (filePhysicalName != null ? filePhysicalName.hashCode() : 0);
        result = 31 * result + (fileAddress != null ? fileAddress.hashCode() : 0);
        result = 31 * result + (storageId != null ? storageId.hashCode() : 0);
        result = 31 * result + (folderId != null ? folderId.hashCode() : 0);
        result = 31 * result + (privacy != null ? privacy.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
        return result;
    }
}
