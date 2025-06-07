package com.demo.controller.rest;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockTvProxy implements QuarkusTestResourceLifecycleManager {
    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer(8089);
        wireMockServer.start();
        configureFor(8089);

        stubFor(get(urlEqualTo("/singlesearch/shows?q=denis"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                  {
                                    "id": 1,
                                    "url": "https://www.tvmaze.com/shows/1/denis",
                                    "name": "Lord Denis",
                                    "summary": "<p>Test summary.</p>",
                                    "language": "English",
                                    "genres": [
                                      "Comedy"
                                    ],
                                    "officialSite": null
                                  }
                                """)));

        stubFor(get(urlMatching(".*"))
                .atPriority(10)
                .willReturn(aResponse()
                        .proxiedFrom("https://api.tvmaze.com")));

        return Collections.singletonMap("com.demo.proxy.TvProxy/mp-rest/uri", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }
}
