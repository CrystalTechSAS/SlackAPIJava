package integrations.slack.net.utils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class HTTPUtils {
    public static void putContent(HttpURLConnection connection, String content) throws IOException {
        OutputStream out = connection.getOutputStream();
        out.write(content.toString().getBytes(Charset.forName("UTF-8")));
        out.flush();
    }
    public static StringBuilder readResponse(InputStream in) throws IOException {
        final char[] buffer = new char[1024];
        final StringBuilder cont = new StringBuilder(1024);
        final java.io.InputStreamReader reader = new java.io.InputStreamReader(in);
        for(int n; (n = reader.read(buffer)) != -1; )cont.append(buffer, 0, n);
        return cont;
    }
    
     public static String getAuthToken(String username, String password){
        String credentials = username + ":" + password;
        String credBase64 = java.util.Base64.getEncoder().encodeToString(credentials.getBytes()).replace("\n", "");
        return "Basic "+credBase64;
    }
}
