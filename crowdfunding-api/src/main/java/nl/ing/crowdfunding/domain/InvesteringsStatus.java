package nl.ing.crowdfunding.domain;

/**
 * Created by M04B081 on 12-11-2014.
 */
public enum InvesteringsStatus {
    toegezegd, betaald;

    public static InvesteringsStatus fromValue(String strStatus) {
        switch (strStatus) {
            case "toegezegd":
                return toegezegd;
            case "betaald":
                return betaald;
            default:
                return toegezegd;
        }
    }
}
