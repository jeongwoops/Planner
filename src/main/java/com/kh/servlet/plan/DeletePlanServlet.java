<<<<<<< HEAD:src/main/java/com/kh/servlet/DeletePlanServlet.java
package com.kh.Servlet;

import java.io.IOException;
import java.util.List;
=======
package com.kh.servlet.plan;
>>>>>>> ab3f356bc423c7620c2e10c7dc3a766c08bbcd29:src/main/java/com/kh/servlet/plan/DeletePlanServlet.java

import com.kh.model.dao.PlanDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DeletePlanController
 */
@WebServlet("/delete.pl")
public class DeletePlanServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    response.setCharacterEncoding("utf-8");
    String userId = "validUserId0";
    String planIdS = request.getParameter("planId");
    int planId = Integer.parseInt(planIdS);
    int result = new PlanDao().deleteByPlanIdAndWriter(planId, userId);

    PrintWriter out = response.getWriter();
    if (result != 0) {
//			request.getRequestDispatcher("main.html").forward(request, response);
      response.setStatus(200);
    } else {
      response.setStatus(400);
    }
    out.close();
//		if(result != 0) {
////		List<Plan> list = new PlanDao().findByWriter(userId);
//		HttpSession session = request.getSession();
//		session.setAttribute("planList", list);
//		response.sendRedirect("/plan/showPlanForm.jsp");
//		} else {
//			response.getWriter().print("삭제 실패했어요 ㅠㅠ");
//		}


  }


}
