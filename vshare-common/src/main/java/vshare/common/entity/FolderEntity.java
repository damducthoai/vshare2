package vshare.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "folder", schema = "vshare", catalog = "")
public class FolderEntity {
    private long folderId;
    private Long folderParent;
    private String folderName;
    private Long storageId;
    private String privacy;
    private String status;

    @Id
    @Column(name = "folder_id", nullable = false)
    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }

    @Basic
    @Column(name = "folder_parent", nullable = true)
    public Long getFolderParent() {
        return folderParent;
    }

    public void setFolderParent(Long folderParent) {
        this.folderParent = folderParent;
    }

    @Basic
    @Column(name = "folder_name", nullable = false, length = 250)
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FolderEntity that = (FolderEntity) o;

        if (folderId != that.folderId) return false;
        if (folderParent != null ? !folderParent.equals(that.folderParent) : that.folderParent != null) return false;
        if (folderName != null ? !folderName.equals(that.folderName) : that.folderName != null) return false;
        if (storageId != null ? !storageId.equals(that.storageId) : that.storageId != null) return false;
        if (privacy != null ? !privacy.equals(that.privacy) : that.privacy != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (folderId ^ (folderId >>> 32));
        result = 31 * result + (folderParent != null ? folderParent.hashCode() : 0);
        result = 31 * result + (folderName != null ? folderName.hashCode() : 0);
        result = 31 * result + (storageId != null ? storageId.hashCode() : 0);
        result = 31 * result + (privacy != null ? privacy.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
