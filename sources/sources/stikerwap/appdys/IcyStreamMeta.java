package stikerwap.appdys;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IcyStreamMeta {
    private Map<String, String> metadata;
    protected URL streamUrl;

    public IcyStreamMeta(URL url) {
        setStreamUrl(url);
    }

    public String getArtist() throws IOException {
        Map<String, String> metadata2 = getMetadata();
        if (metadata2 == null || !metadata2.containsKey("StreamTitle")) {
            return "";
        }
        try {
            String str = metadata2.get("StreamTitle");
            return str.substring(0, str.indexOf("-")).trim();
        } catch (StringIndexOutOfBoundsException unused) {
            return "";
        }
    }

    public String getTitle() throws IOException {
        Map<String, String> metadata2 = getMetadata();
        if (metadata2 == null || !metadata2.containsKey("StreamTitle")) {
            return "";
        }
        try {
            String str = metadata2.get("StreamTitle");
            return str.substring(str.indexOf("-") + 1).trim();
        } catch (StringIndexOutOfBoundsException unused) {
            return "";
        }
    }

    public Map<String, String> getMetadata() throws IOException {
        if (this.metadata == null) {
            refreshMeta();
        }
        return this.metadata;
    }

    public void refreshMeta() throws IOException {
        retreiveMetadata();
    }

    private void retreiveMetadata() throws IOException {
        int i;
        URLConnection openConnection = this.streamUrl.openConnection();
        openConnection.setRequestProperty("Icy-MetaData", "1");
        openConnection.setRequestProperty("Connection", "close");
        openConnection.connect();
        Map<String, List<String>> headerFields = openConnection.getHeaderFields();
        InputStream inputStream = openConnection.getInputStream();
        if (headerFields == null || !headerFields.containsKey("icy-metaint")) {
            StringBuilder sb = new StringBuilder();
            String str = "";
            while (true) {
                char read = (char) inputStream.read();
                if (read == 65535) {
                    break;
                }
                str = str + read;
                sb.append(read);
                if (str.length() > 4000 || (sb.length() > 5 && sb.substring(sb.length() - 4, sb.length()).equals("\r\n\r\n"))) {
                    break;
                }
            }
            Matcher matcher = Pattern.compile("\\r\\n(icy-metaint):\\s*(.*)\\r\\n").matcher(sb.toString());
            i = matcher.find() ? Integer.parseInt(matcher.group(2)) : 0;
        } else {
            i = Integer.parseInt((String) headerFields.get("icy-metaint").get(0));
        }
        if (i != 0) {
            StringBuilder sb2 = new StringBuilder();
            int i2 = 4080;
            int i3 = 0;
            do {
                int read2 = inputStream.read();
                if (read2 == -1) {
                    break;
                }
                boolean z = true;
                i3++;
                int i4 = i + 1;
                if (i3 == i4) {
                    i2 = read2 * 16;
                }
                if (i3 <= i4 || i3 >= i + i2) {
                    z = false;
                }
                if (z && read2 != 0) {
                    sb2.append((char) read2);
                }
            } while (i3 <= i + i2);
            this.metadata = parseMetadata(sb2.toString());
            inputStream.close();
        }
    }

    public void setStreamUrl(URL url) {
        this.metadata = null;
        this.streamUrl = url;
    }

    public static Map<String, String> parseMetadata(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split(";");
        Pattern compile = Pattern.compile("^([a-zA-Z]+)=\\'([^\\']*)\\'$");
        for (String matcher : split) {
            Matcher matcher2 = compile.matcher(matcher);
            if (matcher2.find()) {
                hashMap.put(matcher2.group(1), matcher2.group(2));
            }
        }
        return hashMap;
    }
}
