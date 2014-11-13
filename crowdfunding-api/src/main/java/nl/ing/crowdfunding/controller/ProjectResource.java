package nl.ing.crowdfunding.controller;

import nl.ing.crowdfunding.domain.Project;
import nl.ing.crowdfunding.service.ProjectService;
import nl.ing.crowdfunding.util.ResourceUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/projecten")
@Controller
public class ProjectResource {

    @Resource
    private ProjectService projectService = new ProjectService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Project get(@PathParam("id") String id) {
        return projectService.getById(id);
    }

    @Path("/klant/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getByKlantId(@PathParam("id") String klantId) {
        return projectService.getByKlantId(klantId);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Project project) {
        projectService.save(project);
        return ResourceUtil.response(project.toString());
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") String id) {
        projectService.deleteById(id);
        return ResourceUtil.response(String.format("deleted klant %s", id));
    }

}
