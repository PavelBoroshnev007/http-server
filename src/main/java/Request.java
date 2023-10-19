import java.util.HashMap;
import java.util.Map;

public class Request {
    private final Map<String, String> queryParams;

    public Request(String queryString) {
        this.queryParams = parseQueryParams(queryString);
    }

    public String getQueryParam(String name) {
        return queryParams.get(name);
    }

    public Map<String, String> getQueryParams() {
        return new HashMap<>(queryParams);
    }

    private Map<String, String> parseQueryParams(String queryString) {
        Map<String, String> queryParams = new HashMap<>();
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length > 1) {
                String key = keyValue[0];
                String value = keyValue[1];
                queryParams.put(key, value);
            }
        }
        return queryParams;
    }
}
