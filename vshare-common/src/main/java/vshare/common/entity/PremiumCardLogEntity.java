package vshare.common.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "premium_card_log", schema = "vshare", catalog = "")
public class PremiumCardLogEntity {
    private String cardSerial;
    private long userId;
    private Date actived;

    @Id
    @Column(name = "card_serial", nullable = false, length = 255)
    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "actived", nullable = false)
    public Date getActived() {
        return actived;
    }

    public void setActived(Date actived) {
        this.actived = actived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremiumCardLogEntity logEntity = (PremiumCardLogEntity) o;

        if (userId != logEntity.userId) return false;
        if (cardSerial != null ? !cardSerial.equals(logEntity.cardSerial) : logEntity.cardSerial != null) return false;
        if (actived != null ? !actived.equals(logEntity.actived) : logEntity.actived != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardSerial != null ? cardSerial.hashCode() : 0;
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (actived != null ? actived.hashCode() : 0);
        return result;
    }
}
