package DesignPatterns.Builder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    // notice that final fields make the class immutable.
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;
    private final boolean followRedirects;

    // Private constructor - only accessible via Builder
    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeout = builder.timeout;
        this.followRedirects = builder.followRedirects;
    }

    public String getUrl() { return url; }
    public String getMethod() { return method; }
    public Map<String, String> getHeaders() { return headers; }
    public String getBody() { return body; }
    public int getTimeout() { return timeout; }
    public boolean isFollowRedirects() { return followRedirects; }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                ", followRedirects=" + followRedirects +
                '}';
    }

    // Builder class
    public static class Builder {
        // Required parameters
        private final String url;
        
        // Optional parameters with default values
        private String method = "GET";
        private Map<String, String> headers = new HashMap<>();
        private String body = "";
        private int timeout = 30;
        private boolean followRedirects = true;

        // Constructor with required parameters
        public Builder(String url) {
            this.url = url;
        }

        // Setter methods that return the builder itself
        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timeout(int seconds) {
            this.timeout = seconds;
            return this;
        }

        public Builder followRedirects(boolean follow) {
            this.followRedirects = follow;
            return this;
        }

        // Build method to create the HttpRequest object
        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}