package web.member.controller;

import static core.util.Constants.PREFIX_WEB_INF;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.util.CommonUtil;
import web.member.entity.Member;
import web.member.service.MemberService;

@WebServlet("/member/manage")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 1.添加 MemberService 型態變數
	private MemberService service;
	
	// 2.override init()方法
	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), MemberService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3.將 SERVICE 改成 service
		List<Member> memberList = service.findAll();
		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher(PREFIX_WEB_INF + "/member/manage.jsp").forward(request, response);
	}
}
