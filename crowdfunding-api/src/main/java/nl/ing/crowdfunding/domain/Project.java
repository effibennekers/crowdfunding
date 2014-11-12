package nl.ing.crowdfunding.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by M04B081 on 12-11-2014.
 */
public class Project {

    private int projectid;
    private String titel;
    private Date aangemeld;
    private String beschrijving;
    private BigDecimal doelbedrag;
    private int opentijd;
    private BigDecimal rentepercentage;
    private int risicoprofiel;
    private int eigenaar;
    private int eigenaarrisicoprofiel;
    private ProjectStatus status;

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Date getAangemeld() {
        return aangemeld;
    }

    public void setAangemeld(Date aangemeld) {
        this.aangemeld = aangemeld;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public BigDecimal getDoelbedrag() {
        return doelbedrag;
    }

    public void setDoelbedrag(BigDecimal doelbedrag) {
        this.doelbedrag = doelbedrag;
    }

    public int getOpentijd() {
        return opentijd;
    }

    public void setOpentijd(int opentijd) {
        this.opentijd = opentijd;
    }

    public BigDecimal getRentepercentage() {
        return rentepercentage;
    }

    public void setRentepercentage(BigDecimal rentepercentage) {
        this.rentepercentage = rentepercentage;
    }

    public int getRisicoprofiel() {
        return risicoprofiel;
    }

    public void setRisicoprofiel(int risicoprofiel) {
        this.risicoprofiel = risicoprofiel;
    }

    public int getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(int eigenaar) {
        this.eigenaar = eigenaar;
    }

    public int getEigenaarrisicoprofiel() {
		return eigenaarrisicoprofiel;
	}

	public void setEigenaarrisicoprofiel(int eigenaarrisicoprofiel) {
		this.eigenaarrisicoprofiel = eigenaarrisicoprofiel;
	}

	public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}