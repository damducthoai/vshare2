package vshare.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "storage", schema = "vshare", catalog = "")
public class StorageEntity {
    private long storageId;
    private Long userId;
    private Long maxSize;
    private Long currentSize;

    @Id
    @Column(name = "storage_id", nullable = false)
    public long getStorageId() {
        return storageId;
    }

    public void setStorageId(long storageId) {
        this.storageId = storageId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "max_size", nullable = true)
    public Long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    @Basic
    @Column(name = "current_size", nullable = true)
    public Long getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Long currentSize) {
        this.currentSize = currentSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorageEntity that = (StorageEntity) o;

        if (storageId != that.storageId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (maxSize != null ? !maxSize.equals(that.maxSize) : that.maxSize != null) return false;
        if (currentSize != null ? !currentSize.equals(that.currentSize) : that.currentSize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (storageId ^ (storageId >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (maxSize != null ? maxSize.hashCode() : 0);
        result = 31 * result + (currentSize != null ? currentSize.hashCode() : 0);
        return result;
    }
}
