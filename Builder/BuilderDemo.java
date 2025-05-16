package DesignPatterns.Builder;

public class BuilderDemo {
    public static void main(String[] args) {
        // Simple GET request
        HttpRequest getRequest = new HttpRequest.Builder("https://api.example.com/users")
                .build();
        
        // More complex POST request with headers, body and custom settings
        HttpRequest postRequest = new HttpRequest.Builder("https://api.example.com/users")
                .method("POST")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer token123")
                .body("{\"name\":\"John Doe\",\"email\":\"john@example.com\"}")
                .timeout(60)
                .followRedirects(false)
                .build();
        
        // Print the requests to see what we built
        System.out.println("GET Request:");
        System.out.println(getRequest);
        
        System.out.println("\nPOST Request:");
        System.out.println(postRequest);
    }
}