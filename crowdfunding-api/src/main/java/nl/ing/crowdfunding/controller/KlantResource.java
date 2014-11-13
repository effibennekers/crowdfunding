package nl.ing.crowdfunding.controller;

import nl.ing.crowdfunding.domain.Klant;
import nl.ing.crowdfunding.service.KlantService;
import nl.ing.crowdfunding.util.ResourceUtil;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/klanten")
public class KlantResource {

    @Resource
    private KlantService klantService = new KlantService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Klant> getAll() {
        return klantService.getAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Klant get(@PathParam("id") String id) {
        return klantService.getById(id);
    }

    @Path("/login")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Klant get(@QueryParam("email") String email, @QueryParam("password") String password) {
        return klantService.getByEmail(email, password);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Klant klant) {
        klantService.save(klant);
        return ResourceUtil.response(klant.getEmail());
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") String id) {
        klantService.deleteById(id);
        return ResourceUtil.response(String.format("deleted klant %s", id));
    }

}
