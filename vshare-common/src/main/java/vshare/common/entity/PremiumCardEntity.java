package vshare.common.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "premium_card", schema = "vshare", catalog = "")
public class PremiumCardEntity {
    private String cardSerial;
    private String cardCode;
    private Date created;
    private Long point;
    private Date lastModified;
    private String cardStatus;

    @Id
    @Column(name = "card_serial", nullable = false, length = 255)
    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    @Basic
    @Column(name = "card_code", nullable = false, length = 255)
    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    @Basic
    @Column(name = "created", nullable = true)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
    @Column(name = "last_modified", nullable = true)
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Basic
    @Column(name = "card_status", nullable = true, length = 100)
    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremiumCardEntity that = (PremiumCardEntity) o;

        if (cardSerial != null ? !cardSerial.equals(that.cardSerial) : that.cardSerial != null) return false;
        if (cardCode != null ? !cardCode.equals(that.cardCode) : that.cardCode != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (lastModified != null ? !lastModified.equals(that.lastModified) : that.lastModified != null) return false;
        if (cardStatus != null ? !cardStatus.equals(that.cardStatus) : that.cardStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardSerial != null ? cardSerial.hashCode() : 0;
        result = 31 * result + (cardCode != null ? cardCode.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (cardStatus != null ? cardStatus.hashCode() : 0);
        return result;
    }
}
