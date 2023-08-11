package web.member.controller;

import static core.util.CommonUtil.json2Pojo;
import static core.util.CommonUtil.writePojo2Json;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.util.CommonUtil;
import web.member.entity.Member;
import web.member.service.MemberService;

@WebServlet("/member/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 1.添加 MemberService 型態變數
	private MemberService service;
	
	// 2.override init()方法
	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), MemberService.class);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		final HttpSession session = request.getSession();
		final String username = ((Member) session.getAttribute("member")).getUsername();
		Member member = json2Pojo(request, Member.class);
		member.setUsername(username);
		// 3.將 SERVICE 改成 service
		writePojo2Json(response, service.edit(member));
	}
	// 4. Ctrl + Shift + O
}
