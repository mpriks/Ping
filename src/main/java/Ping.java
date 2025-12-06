import java.net.HttpURLConnection;
import java.net.URL;

public class Ping {

    void pingUntilSuccess(String targetUrl) {

        while (true) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(targetUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    System.out.println(targetUrl + " - Ping successful!");
                    Notifier.notifySuccess(targetUrl);
                    break; // we're done
                } else {
                    System.out.println(targetUrl + " - Ping failed with response code: " + responseCode);
                }
            } catch (Exception e) {
                System.out.println(java.time.LocalTime.now().withNano(0) + " " + targetUrl + " - Ping failed: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

            // wait a bit before retrying
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                System.out.println("Ping loop interrupted, stopping.");
                break;
            }
        }
    }

}
