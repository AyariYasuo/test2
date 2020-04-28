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
import action.FileDownload;

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
        	url = "/chart.jsp";
        }else {
        	switch(action){
            case "examineeInfo":
            	examineeInfoList = ExamineeInfo.ExamineeInfoGet();
            	if(examineeInfoList==null || examineeInfoList.size() == 0){
                	request.setAttribute("err", "受験者情報が存在しません");
            	}
            	request.setAttribute("ExamineeInfoList", examineeInfoList);
            	request.setAttribute("flg", "1");
                url = "/examineeInfo.jsp";
                break;
            case "chart":
            	if(request.getParameter("examineeId")==null || request.getParameter("examineeId").equals("")){
                	request.setAttribute("ExamineeInfoList", examineeInfoList);
                	request.setAttribute("flg", "1");
                	request.setAttribute("err", "受験者を選択してください");
            		url = "/examineeInfo.jsp";
                    break;
            	}
            	examineeInfo = Chart.chart(examineeInfoList, request.getParameter("examineeId"));
            	request.setAttribute("ExamineeInfo", examineeInfo);
                url = "/chart.jsp";
                break;
            case "download":
            	FileDownload.fileDownload(response);
            	request.setAttribute("ExamineeInfoList", examineeInfoList);
            	request.setAttribute("flg", "1");
                url = "/examineeInfo.jsp";
                break;
            default:
            	url = "/chart.jsp";
                break;
        	}
        }

        RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
