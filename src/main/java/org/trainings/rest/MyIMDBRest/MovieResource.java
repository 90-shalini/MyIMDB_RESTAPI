package org.trainings.rest.MyIMDBRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.trainings.rest.MyIMDBUtilities.MovieService;

@Path("movies")
public class MovieResource {
	
	MovieService movieService = new MovieService();
	
	@GET
	@Path("/{movieID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMovieTitle(@PathParam("movieID") int id){
		String title = movieService.getMovieDetail(id);
		return title; 
	}
}
