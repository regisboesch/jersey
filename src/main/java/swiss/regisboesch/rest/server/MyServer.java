package swiss.regisboesch.rest.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class MyServer {

	public MyServer() {
	}

	/**
	 * Launch Jetty Server
	 * @throws Exception 
	 */
	public void launchServer() throws Exception {
		ResourceConfig config = new ResourceConfig();
		config.packages("swiss.regisboesch.rest.resources");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(2222);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}

	public static void main(String[] args) throws Exception {
		MyServer myServer = new MyServer();
		myServer.launchServer();
	}

}
