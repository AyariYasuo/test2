package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Chart;
import action.ExamineeInfo;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Map<String,Object>> examineeInfoList;
	private Map<String,Object> examineeInfo;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
		try {
			this.process(request, response);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServslet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
		try {
			this.process(request, response);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

        // 遷移先
        String url = null;

        if(action==null || action=="") {
        	url = "/top.jsp";
        }else {
        	switch(action){
            case "examineeInfo":
            	examineeInfoList = ExamineeInfo.ExamineeInfoGet();
            	request.setAttribute("ExamineeInfoList", examineeInfoList);
                url = "/examineeInfo.jsp";
                break;
            case "chart":
            	examineeInfo = Chart.chart(examineeInfoList, request.getParameter("examineeId"));
            	request.setAttribute("ExamineeInfo", examineeInfo);
                url = "/chart.jsp";
                break;
            default:
            	url = "/top.jsp";
                break;
        	}
        }

        RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
