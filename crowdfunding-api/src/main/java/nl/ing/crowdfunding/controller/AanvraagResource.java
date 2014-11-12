package nl.ing.crowdfunding.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.ing.crowdfunding.domain.Aanvraag;
import nl.ing.crowdfunding.service.AanvraagService;

import com.sun.jersey.api.core.InjectParam;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Path("/aanvragen")
public class AanvraagResource {

    private AanvraagService aanvraagService;

    @Path("/aanvragen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aanvraag> getAanvragen() {
        return aanvraagService.getAllAanvragen();
    }

    @Path("/aanvraag/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Aanvraag getAanvraag(@PathParam("id") String id) {
        return aanvraagService.getAanvraag(id);
    }

    @Path("/aanvraag")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putAanvraag(Aanvraag aanvraag) {
        aanvraagService.saveAanvraag(aanvraag);
        return response(aanvraag.toString());
    }

    @Path("/aanvraag/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteAanvraag(@PathParam("id") String id) {
        aanvraagService.deleteAanvraag(id);
        return response(String.format("deleted aanvraag %s", id));
    }

	private Response response(String entity) {
		return Response.status(200).entity(entity).build();
	}

}
