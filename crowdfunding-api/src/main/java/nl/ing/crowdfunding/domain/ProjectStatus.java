package nl.ing.crowdfunding.domain;

/**
 * Created by M04B081 on 12-11-2014.
 */
public enum ProjectStatus {
    bouw, open, loopt, gestopt, afgerond;
    
    public static ProjectStatus fromValue(String strStatus) {
    	switch (strStatus) {
    	case "bouw": return bouw;
    	case "open": return open;
    	case "loopt": return loopt;
    	case "gestopt": return gestopt;
    	case "afgerond": return afgerond;
    	default: return bouw;
    	}
    }
}
