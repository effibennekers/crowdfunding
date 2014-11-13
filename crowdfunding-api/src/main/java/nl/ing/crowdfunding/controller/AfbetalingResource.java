package nl.ing.crowdfunding.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.ing.crowdfunding.domain.Afbetaling;
import nl.ing.crowdfunding.service.AfbetalingService;
import nl.ing.crowdfunding.util.ResourceUtil;

@Path("/afbetalingen")
public class AfbetalingResource {

    @Resource
    private AfbetalingService afbetalingService = new AfbetalingService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Afbetaling> getAll() {
        return afbetalingService.getAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Afbetaling get(@PathParam("id") String id) {
        return afbetalingService.getById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Afbetaling afbetaling) {
        afbetalingService.save(afbetaling);
        return ResourceUtil.response(afbetaling.toString());
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") String id) {
        afbetalingService.deleteById(id);
        return ResourceUtil.response(String.format("deleted afbetaling %s", id));
    }

}
