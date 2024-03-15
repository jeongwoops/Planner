package com.kh.servlet;

import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/signup/userid/duplicate")
public class UserIdDuplicateServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userId = req.getParameter("userId");
    if (userId == null) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    User user = new UserDao().findByUserId(userId);
    if (user != null) {
      resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

    resp.setStatus(HttpServletResponse.SC_OK);
  }
}
