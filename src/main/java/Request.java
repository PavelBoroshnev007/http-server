import java.util.HashMap;
import java.util.Map;

public class Request {
    private final Map<String, String> queryParams;

    public Request(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getQueryParam(String name) {
        return queryParams.get(name);
    }

    public Map<String, String> getQueryParams() {
        return new HashMap<>(queryParams);
    }
}
