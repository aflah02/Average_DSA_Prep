//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import org.json.simple.JSONObject;
//public class api {
//    public static void main(String[] args) {
//        JSONObject obj = new JSONObject();
//        HttpClient client = HttpClient.newHttpClient();
////        URI uri = new URI("https://www.google.com/");
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://opentdb.com/api.php?amount=1&difficulty=easy&type=boolean"))
//                .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
//    }
//}
