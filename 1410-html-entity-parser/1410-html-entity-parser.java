import java.util.HashMap;
import java.util.Map;

class Solution {
    public String entityParser(String text) {
        Map<String, String> entities = new HashMap<>();
        entities.put("&quot;", "\"");
        entities.put("&apos;", "'");
        entities.put("&amp;", "&");
        entities.put("&gt;", ">");
        entities.put("&lt;", "<");
        entities.put("&frasl;", "/");

        StringBuilder result = new StringBuilder();
        int n = text.length();
        int i = 0;

        while (i < n) {
            boolean matched = false;
            if (text.charAt(i) == '&') {
                for (int len = 4; len <= 7; len++) {
                    if (i + len <= n) {
                        String sub = text.substring(i, i + len);
                        if (entities.containsKey(sub)) {
                            result.append(entities.get(sub));
                            i += len;
                            matched = true;
                            break;
                        }
                    }
                }
            }

            if (!matched) {
                result.append(text.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
