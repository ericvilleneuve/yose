package com.evil.yose;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HelloYoseTest {

	private Yose server;

	@Before
	public void startServer() throws IOException {
		server = new Yose(9866);
		server.start();
	}

	@After
	public void stopServer() throws IOException {
		server.stop();
	}

	@Test
	public void respondsHelloYoseTest() throws IOException {
		HttpResponse response = new HttpRequest(9866).get("/");

		assertThat(response.statusCode(), equalTo(200));
		assertThat(response.contentType(), equalTo("text/html"));
		assertThat(response.bodyText(), containsString("Hello Yose"));
	}

}
