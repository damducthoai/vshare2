package vshare.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "premium_card_log", schema = "vshare", catalog = "")
public class PremiumCardLogEntity {
    private String cardSerial;
    private Timestamp actived;

    @Id
    @Column(name = "card_serial", nullable = false, length = 255)
    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    @Basic
    @Column(name = "actived", nullable = false)
    public Timestamp getActived() {
        return actived;
    }

    public void setActived(Timestamp actived) {
        this.actived = actived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremiumCardLogEntity that = (PremiumCardLogEntity) o;

        if (cardSerial != null ? !cardSerial.equals(that.cardSerial) : that.cardSerial != null) return false;
        if (actived != null ? !actived.equals(that.actived) : that.actived != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardSerial != null ? cardSerial.hashCode() : 0;
        result = 31 * result + (actived != null ? actived.hashCode() : 0);
        return result;
    }
}
