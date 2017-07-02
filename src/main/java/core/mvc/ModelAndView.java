package core.mvc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MilkChul on 2017. 7. 2..
 */
public class ModelAndView {
    private View view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public ModelAndView addAttribute(String attributeName, Object attributeObject) {
        model.put(attributeName, attributeObject);
        return this;
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }

    public View getView() {
        return view;
    }
}
