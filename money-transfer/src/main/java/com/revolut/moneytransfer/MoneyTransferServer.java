package com.revolut.moneytransfer;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revolut.moneytransfer.util.MoneyTransferConstants;

/**
 * @author rohsingh
 *
 */
public class MoneyTransferServer {

	private static final Logger Log = LoggerFactory.getLogger(MoneyTransferServer.class);

	private MoneyTransferServer() {
	}

	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		Log.info("Server Started with WADL available at : {}\n Hit Enter to stop it...",
				MoneyTransferConstants.BASE_URI);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Stopping server..");
			server.shutdownNow();
		}, "shutdownHook"));

		// run
		try {
			server.start();
			System.out.println("Press CTRL^C to exit..");
			Thread.currentThread().join();
		} catch (Exception e) {
			System.out.println(String.format("There was an error while starting Grizzly HTTP server.\n%s",
					e.getLocalizedMessage()));
		}
	}

	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("com.revolut.moneytransfer");
		rc.property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, "true");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(MoneyTransferConstants.BASE_URI), rc);
	}

}
