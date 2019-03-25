package notebook.view;

import java.util.HashMap;
import java.util.Map;

public class ModelView implements View {

    private String pageUrl;
    private Map<String, Object> pageParam = new HashMap<>();

    public ModelView() {
    }

    public ModelView(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }

    @Override
    public void addParameter(String key, Object value) {
        pageParam.put(key, value);
    }

    @Override
    public void removeParameter(String key) {
        pageParam.remove(key);
    }

    @Override
    public Map<String, Object> getParameters() {
        return pageParam;
    }

}
