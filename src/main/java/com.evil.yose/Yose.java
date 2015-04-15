package com.evil.yose;

import com.vtence.molecule.WebServer;
import com.vtence.molecule.http.HttpStatus;
import com.vtence.molecule.http.MimeTypes;

import java.io.IOException;

public class Yose {

	private final WebServer server;

	public Yose(int port) {
		server = WebServer.create(port);
	}

	public void start() throws IOException {
		server.start((request, response) -> {
			response.status(HttpStatus.OK);
			response.contentType(MimeTypes.HTML);
			response.body("Hello Yose");
		});
	}

	public void stop() throws IOException {
		server.stop();
	}
}
