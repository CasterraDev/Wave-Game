import java.io.IOException;

public class Utility {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void openURL(String domain)
    {
        String url = "https://" + domain;
        Runtime rt = Runtime.getRuntime();
        try {
            if (isWindows()) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url).waitFor();
                System.out.println("Browser: " + url);
            } else if (isMac()) {
                String[] cmd = {"open", url};
                rt.exec(cmd).waitFor();
                System.out.println("Browser: " + url);
            } else if (isUnix()) {
                String[] cmd = {"xdg-open", url};
                rt.exec(cmd).waitFor();
                System.out.println("Browser: " + url);
            } else {
                try {
                    throw new IllegalStateException();
                } catch (IllegalStateException e1) {
                    e1.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isWindows()
    {
        return OS.contains("win");
    }

    public static boolean isMac()
    {
        return OS.contains("mac");
    }

    public static boolean isUnix()
    {
        return OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0;
    }
}
