package core.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by MilkChul on 2017. 7. 2..
 */
public class JspView implements View {
    private static final String REDIRECT = "redirect:";

    private String viewName;

    public JspView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if(viewName.startsWith(REDIRECT)) {
            resp.sendRedirect(viewName.substring(REDIRECT.length()));

            return;
        }

        Set<String> keySet = model.keySet();
        for(String key : keySet) {
            req.setAttribute(key, model.get(key));
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewName);
        requestDispatcher.forward(req, resp);
    }
}
