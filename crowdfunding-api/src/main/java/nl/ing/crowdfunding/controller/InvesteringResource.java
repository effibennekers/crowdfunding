package nl.ing.crowdfunding.controller;

import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.service.InvesteringService;
import nl.ing.crowdfunding.util.ResourceUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/investeringen")
@Controller
public class InvesteringResource {

    @Resource
    private InvesteringService investeringService = new InvesteringService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Investering> getAll() {
        return investeringService.getAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Investering get(@PathParam("id") String id) {
        return investeringService.getById(id);
    }

    @Path("/project/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Investering> getByProjectId(@PathParam("id") String projectId) {
        return investeringService.getByProjectId(projectId);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Investering investering) {
        investeringService.save(investering);
        return ResourceUtil.response(investering.toString());
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") String id) {
        investeringService.deleteById(id);
        return ResourceUtil.response(String.format("deleted investering %s", id));
    }

}
