package nl.ing.crowdfunding.domain;

/**
 * Created by M04B081 on 12-11-2014.
 */
public enum ProjectStatus {
    BOUW, OPEN, LOOPT, GESTOPT, AFGEROND;
    
    public static ProjectStatus fromValue(String strStatus) {
    	switch (strStatus) {
    	case "BOUW": return BOUW;
    	case "OPEN": return OPEN;
    	case "LOOPT": return LOOPT;
    	case "GESTOPT": return GESTOPT;
    	case "AFGEROND": return AFGEROND;
    	default: return BOUW;
    	}
    }
}
