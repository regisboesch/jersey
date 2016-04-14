package swiss.regisboesch.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Test class for REST API Jersey resources implementation
 * 
 * @author regis
 *
 */
@Path("test")
public class TestResources {

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}
}
