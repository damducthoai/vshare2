package vshare.common.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FileServerMetaEntityPK implements Serializable {
    private String serverIp;
    private long fileId;

    @Column(name = "server_ip", nullable = false, length = 255)
    @Id
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Column(name = "file_id", nullable = false)
    @Id
    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileServerMetaEntityPK that = (FileServerMetaEntityPK) o;

        if (fileId != that.fileId) return false;
        if (serverIp != null ? !serverIp.equals(that.serverIp) : that.serverIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serverIp != null ? serverIp.hashCode() : 0;
        result = 31 * result + (int) (fileId ^ (fileId >>> 32));
        return result;
    }
}
