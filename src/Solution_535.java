import java.util.HashMap;
import java.util.Map;

public class Solution_535 {

  Map<Integer, String> map = new HashMap<>();


  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    int key = longUrl.hashCode();
    map.put(key, longUrl);
    return String.valueOf(key);
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    int key = Integer.parseInt(shortUrl);
    return map.get(key);
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));