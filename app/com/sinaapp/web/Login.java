package com.sinaapp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weibo4j.User;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.examples.WebOAuth;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登录新浪微薄以获取授权
		String verifier=request.getParameter("oauth_verifier");
		String oauth_token = request.getParameter("oauth_token");
		String invitedid = request.getParameter("invitedid");
		if(verifier!=null){
			//用户已登录
			System.out.println(" verifier = "+verifier);
			System.out.println(" oauth_token = "+oauth_token);
			Weibo weibo = new Weibo();
			try {
				RequestToken resToken = (RequestToken) request.getSession().getAttribute("resToken");
				AccessToken accessToken = weibo.getOAuthAccessToken(resToken.getToken(),resToken.getTokenSecret(), verifier);
				
				//这个accessToken.getToken(),accessToken.getTokenSecret() 可保持下次使用
				weibo.setToken(accessToken.getToken(),accessToken.getTokenSecret());
				User user = weibo.verifyCredentials();
				System.out.println(user);
				
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				response.getWriter().println(user);
				
				//test
				//WebOAuth.update(accessToken, "@吕建文,哈哈，app发布微薄测试骚扰一下啦,http://s.click.taobao.com/t_3?&p=mm_12273035_0_0&n=23&l=http%3A%2F%2Fs8.taobao.com%2Fbrowse%2F0%2Fn-g%2Cy7u4rs553i----------------40--commend-0-1%2C2-0.htm%3Fpid%3Dmm_12273035_0_0");
				if(user.getId()==1 && invitedid!=null){
					//新用户，并且是被邀请的，给邀请者积分
					
				}
				
				//add user
				//把用户增加到本系统库内，如果没有才增加
				
				
			} catch (WeiboException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			//跳转登录页面
			RequestToken resToken = WebOAuth.request("http://localhost:8080/sinaapp/login?invitedid="+invitedid);
			if(resToken!=null){
				request.getSession(true).setAttribute("resToken",resToken);
				response.sendRedirect(resToken.getAuthorizationURL());
			}else{
				System.out.println(" resToken =null,request error");
			}
		}
		
	}

}
