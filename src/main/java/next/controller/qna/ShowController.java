package next.controller.qna;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.ModelAndView;
import next.dao.AnswerDao;
import next.dao.QuestionDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowController implements Controller {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long questionId = Long.parseLong(req.getParameter("questionId"));
        QuestionDao questionDao = new QuestionDao();
        AnswerDao answerDao = new AnswerDao();

        ModelAndView modelAndView = new ModelAndView(new JspView("/qna/show.jsp"));
        modelAndView.addAttribute("question", questionDao.findById(questionId));
        modelAndView.addAttribute("answers", answerDao.findAllByQuestionId(questionId));

        return modelAndView;
    }
}
