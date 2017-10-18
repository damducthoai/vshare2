package vshare.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "server", schema = "vshare", catalog = "")
public class ServerEntity {
    private String serverIp;
    private long serverSize;
    private long serverUseableSize;
    private String serverUser;
    private String serverAlias;
    private String serverPassword;

    @Id
    @Column(name = "server_ip", nullable = false, length = 255)
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Basic
    @Column(name = "server_size", nullable = false)
    public long getServerSize() {
        return serverSize;
    }

    public void setServerSize(long serverSize) {
        this.serverSize = serverSize;
    }

    @Basic
    @Column(name = "server_useable_size", nullable = false)
    public long getServerUseableSize() {
        return serverUseableSize;
    }

    public void setServerUseableSize(long serverUseableSize) {
        this.serverUseableSize = serverUseableSize;
    }

    @Basic
    @Column(name = "server_user", nullable = false, length = 255)
    public String getServerUser() {
        return serverUser;
    }

    public void setServerUser(String serverUser) {
        this.serverUser = serverUser;
    }

    @Basic
    @Column(name = "server_alias", nullable = false, length = 255)
    public String getServerAlias() {
        return serverAlias;
    }

    public void setServerAlias(String serverAlias) {
        this.serverAlias = serverAlias;
    }

    @Basic
    @Column(name = "server_password", nullable = true, length = 255)
    public String getServerPassword() {
        return serverPassword;
    }

    public void setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerEntity that = (ServerEntity) o;

        if (serverSize != that.serverSize) return false;
        if (serverUseableSize != that.serverUseableSize) return false;
        if (serverIp != null ? !serverIp.equals(that.serverIp) : that.serverIp != null) return false;
        if (serverUser != null ? !serverUser.equals(that.serverUser) : that.serverUser != null) return false;
        if (serverAlias != null ? !serverAlias.equals(that.serverAlias) : that.serverAlias != null) return false;
        if (serverPassword != null ? !serverPassword.equals(that.serverPassword) : that.serverPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serverIp != null ? serverIp.hashCode() : 0;
        result = 31 * result + (int) (serverSize ^ (serverSize >>> 32));
        result = 31 * result + (int) (serverUseableSize ^ (serverUseableSize >>> 32));
        result = 31 * result + (serverUser != null ? serverUser.hashCode() : 0);
        result = 31 * result + (serverAlias != null ? serverAlias.hashCode() : 0);
        result = 31 * result + (serverPassword != null ? serverPassword.hashCode() : 0);
        return result;
    }
}
