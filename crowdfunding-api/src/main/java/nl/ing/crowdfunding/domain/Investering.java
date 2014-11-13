package nl.ing.crowdfunding.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by M04B081 on 12-11-2014.
 */
public class Investering {

    private int id;
    private Klant investeerder;
    private BigDecimal bedrag;
    private Project project;
    private String beloning;
    private BigDecimal rentepercentage;
    private InvesteringsStatus status;
    private int afbetaalperiode;

  public List<Afbetaling> getAfbetalingen() {
    return afbetalingen;
  }

  public void setAfbetalingen(List<Afbetaling> afbetalingen) {
    this.afbetalingen = afbetalingen;
  }

  private List<Afbetaling> afbetalingen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klant getInvesteerder() {
        return investeerder;
    }

    public void setInvesteerder(Klant investeerder) {
        this.investeerder = investeerder;
    }

    public BigDecimal getBedrag() {
        return bedrag;
    }

    public void setBedrag(BigDecimal bedrag) {
        this.bedrag = bedrag;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getBeloning() {
        return beloning;
    }

    public void setBeloning(String beloning) {
        this.beloning = beloning;
    }

    public BigDecimal getRentepercentage() {
        return rentepercentage;
    }

    public void setRentepercentage(BigDecimal rentepercentage) {
        this.rentepercentage = rentepercentage;
    }

    public InvesteringsStatus getStatus() {
        return status;
    }

    public void setStatus(InvesteringsStatus status) {
        this.status = status;
    }

    public int getAfbetaalperiode() {
        return afbetaalperiode;
    }

    public void setAfbetaalperiode(int afbetaalperiode) {
        this.afbetaalperiode = afbetaalperiode;
    }
}
