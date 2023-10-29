package com.msbeigi.librarybackend.model;

public class Utils {
    private static final String HTTP = "http://";

    public static String createHttp(String server, int port, String contextPath, String endpoint) {
        return HTTP + server + ":" + port + "/" + contextPath + endpoint;
    }
}
