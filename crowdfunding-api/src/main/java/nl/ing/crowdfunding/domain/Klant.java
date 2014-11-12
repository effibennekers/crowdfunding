package nl.ing.crowdfunding.domain;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by M04B081 on 12-11-2014.
 */
public class Klant {

    private int klantid;
    private String voornaam;
    private String achternaam;
    private String tussenvoegsels;
    private String straatnaam;
    private int huisnummer;
    private String huisnummerav;
    private String plaats;
    private String debtoriban;
    private String creditoriban;
    private String telefoonnummer;
    private String telefoonnummersms;
    private String telefoonnummermobiel;
    private Date geboortedag;
    private Boolean ingklant;
    private String contract;
    private String email;
    private String postcode;
    private String authtoken;
    private String password;

    public int getKlantid() {
        return klantid;
    }

    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsels() {
        return tussenvoegsels;
    }

    public void setTussenvoegsels(String tussenvoegsels) {
        this.tussenvoegsels = tussenvoegsels;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getHuisnummerav() {
        return huisnummerav;
    }

    public void setHuisnummerav(String huisnummerav) {
        this.huisnummerav = huisnummerav;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getDebtoriban() {
        return debtoriban;
    }

    public void setDebtoriban(String debtoriban) {
        this.debtoriban = debtoriban;
    }

    public String getCreditoriban() {
        return creditoriban;
    }

    public void setCreditoriban(String creditoriban) {
        this.creditoriban = creditoriban;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getTelefoonnummersms() {
        return telefoonnummersms;
    }

    public void setTelefoonnummersms(String telefoonnummersms) {
        this.telefoonnummersms = telefoonnummersms;
    }

    public String getTelefoonnummermobiel() {
        return telefoonnummermobiel;
    }

    public void setTelefoonnummermobiel(String telefoonnummermobiel) {
        this.telefoonnummermobiel = telefoonnummermobiel;
    }

    public Date getGeboortedag() {
        return geboortedag;
    }

    public void setGeboortedag(Date geboortedag) {
        this.geboortedag = geboortedag;
    }

    public Boolean getIngklant() {
        return ingklant;
    }

    public void setIngklant(Boolean ingklant) {
        this.ingklant = ingklant;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
