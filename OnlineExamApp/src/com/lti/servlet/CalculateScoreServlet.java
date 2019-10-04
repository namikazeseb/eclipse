package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.exam.Option;
import com.lti.exam.Question;
import com.lti.exam.QuestionBankLoader;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int optionNo = Integer.parseInt(request.getParameter("op"));
		
		HttpSession session = request.getSession();
		Question q = (Question) session.getAttribute("currentQs");
		
		Integer score = (Integer) session.getAttribute("score");
		if(score == null)
			score = 0;
		Option selectedOption = q.getOptions().get(optionNo);
		if(selectedOption.isRightAnswer())
			score ++;
		
		session.setAttribute("score", score);
		
		response.sendRedirect("QuestionLoaderServlet");
		
		
	}

	

}
