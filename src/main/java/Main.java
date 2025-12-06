
public class Main {

    public static void main(String[] args) {

        String url = "https://www.google.com"; // replace with desired URL

        Ping pinger = new Ping();
        pinger.pingUntilSuccess(url);

    }
}
