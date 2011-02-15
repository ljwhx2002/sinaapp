/**
 * 
 */
package weibo4j.examples.user;

import weibo4j.User;
import weibo4j.Weibo;
import weibo4j.WeiboException;

/**
 * @author sina
 *
 */
public class GetUserInfo {

	/**
	 * 根据用户ID获取用户资料（授权用户） 
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
    	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
		try {
			User user = getWeibo(false,args).showUser("1088683744");
			System.out.println(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
	
	private static Weibo getWeibo(boolean isOauth,String[] args) {
		Weibo weibo = new Weibo();
		if(isOauth) {//oauth验证方式 args[0]:访问的token；args[1]:访问的密匙
			weibo.setToken(args[0], args[1]);
		}else {//用户登录方式
    		weibo.setUserId("ljwhx2002");//用户名/ID
    		weibo.setPassword("123321");//密码
		}
		return weibo;
	}

}
