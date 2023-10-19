package fcu.edu.weber;


public class Main implements Runnable{
    private static WebServer webServer;
    public static WebServer getWebServer(){
        return webServer;
    }

    public Main() throws Exception {
        webServer = new WebServer();
    }

    public static void main( String[] args ) {
        try {
            new Main().run();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }

    @Override
    public void run() {
        getWebServer().run();
    }
}
