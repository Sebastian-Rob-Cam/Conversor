import main.java.com.sebastian.conversor.model.connectionAPI;

public class test {

    public static void main(String[] args) {
        connectionAPI connection = new connectionAPI();
        String usd = connection.getJSON("USD");
        System.out.println(usd);
    }

}
