package edu.project3.launchers;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        String[] ar = new String[5];
        ar[0] = "--path";
        ar[1] = "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs";
        ar[2] = "logs/log1.txt";
        ar[3] = "--to";
        ar[4] = "2017-01-01";
        Launcher launcher = new Launcher(ar);
        launcher.start();

    }
}
