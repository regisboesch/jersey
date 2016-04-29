package swiss.regisboesch.rest.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import swiss.regisboesch.rest.database.myDao;
import swiss.regisboesch.rest.database.model.Currencies;
/**
 * Test class for REST API Jersey resources implementation
 * 
 * @author regis
 *
 */
@Path("test")
public class TestResources {

	@Context private myDao mDao2;
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}
	
	@GET
	@Path("currencies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCurrencies() {
		myDao mDao = new myDao();
		List<Currencies> mCurrencies = mDao.getAllTasks();
		Gson gson = new Gson();
		return Response.ok(gson.toJson(mCurrencies)).build();
	}
}
