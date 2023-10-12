import java.util.HashMap;
import java.util.Map;

public class Request {
    private final Map<String, String> queryParams;

    public Request() {
        this.queryParams = new HashMap<>();
    }

    public void addQueryParam(String name, String value) {
        queryParams.put(name, value);
    }

    public String getQueryParam(String name) {
        return queryParams.get(name);
    }

    public Map<String, String> getQueryParams() {
        return new HashMap<>(queryParams);
    }
}
