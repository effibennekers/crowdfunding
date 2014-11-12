package nl.ing.crowdfunding.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by M04B081 on 10-11-2014.
 */
public class Afbetaling {

    private int id;
    private Investering investering;
    private BigDecimal bedrag;
    private Date datumtijd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Investering getInvestering() {
        return investering;
    }

    public void setInvestering(Investering investering) {
        this.investering = investering;
    }

    public BigDecimal getBedrag() {
        return bedrag;
    }

    public void setBedrag(BigDecimal bedrag) {
        this.bedrag = bedrag;
    }

    public Date getDatumtijd() {
        return datumtijd;
    }

    public void setDatumtijd(Date datumtijd) {
        this.datumtijd = datumtijd;
    }
}
