package nl.ing.crowdfunding.controller;

import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.domain.Klant;
import nl.ing.crowdfunding.service.KlantService;
import nl.ing.crowdfunding.util.ResourceUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/klanten")
@Controller
public class KlantResource {

    @Resource
    private KlantService klantService;

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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Klant klant) {
        klantService.save(klant);
        return ResourceUtil.response(klant.toString());
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") String id) {
        klantService.deleteById(id);
        return ResourceUtil.response(String.format("deleted klant %s", id));
    }

}
