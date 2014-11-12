package nl.ing.crowdfunding.util;

import javax.ws.rs.core.Response;

/**
 * Created by M04B081 on 12-11-2014.
 */
public final class ResourceUtil {

    public static Response response(String entity) {
        return Response.status(200).entity(entity).build();
    }

}
