package vshare.common.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "premium_data", schema = "vshare", catalog = "")
public class PremiumDataEntity {
    private long userId;
    private Long point;
    private Date dueTo;

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "point", nullable = true)
    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    @Basic
    @Column(name = "dueTo", nullable = true)
    public Date getDueTo() {
        return dueTo;
    }

    public void setDueTo(Date dueTo) {
        this.dueTo = dueTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremiumDataEntity that = (PremiumDataEntity) o;

        if (userId != that.userId) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (dueTo != null ? !dueTo.equals(that.dueTo) : that.dueTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (dueTo != null ? dueTo.hashCode() : 0);
        return result;
    }
}
