import com.laboratory.order_service.infrastructure.config.AppConstants;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

static final HttpClient client = HttpClient.newHttpClient();

void main() {
    int totalRequests = 500;
    var counter = new AtomicInteger(0);

    long start = System.currentTimeMillis();

    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
        for (int i = 0; i < totalRequests; i++) {
            executor.submit(() -> {
                try {
                    var request = HttpRequest.newBuilder()
                            .uri(URI.create(AppConstants.LOCAL_API_URL + "/orders"))
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString("{\"amount\": 10.0}"))
                            .build();
                    client.send(request, HttpResponse.BodyHandlers.ofString());
                    counter.incrementAndGet();
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    System.err.println("Error during request: " + e.getMessage());
                }
            });
        }
    }

    long end = System.currentTimeMillis();

    IO.println("Finished in: " + (end - start) + "ms");
    IO.println("Success: " + counter.get() + "/" + totalRequests);
}