package com.redv.jetty.https.connector;

import java.io.IOException;

import org.mortbay.io.EndPoint;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.nio.SelectChannelConnector;

public class HttpsSelectChannelConnector extends SelectChannelConnector {

	@Override
	public void customize(EndPoint endpoint, Request request)
			throws IOException {
		final String protoHeader = request.getHeader("X_FORWARDED_PROTO");
		if ("https".equalsIgnoreCase(protoHeader)) {
			request.setScheme("https");
		}

		super.customize(endpoint, request);
	}

}
