package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by MilkChul on 2017. 7. 2..
 */
public interface View {
    void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
