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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.domain.Klant;
import nl.ing.crowdfunding.service.InvesteringService;
import nl.ing.crowdfunding.util.ResourceUtil;

@Path("/investeringen")
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
