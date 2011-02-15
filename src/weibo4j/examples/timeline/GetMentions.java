/**
 * 
 */
package weibo4j.examples.timeline;

import java.util.List;
import weibo4j.Status;
import weibo4j.Weibo;

/**
 * @author sina
 *
 */
public class GetMentions {

	/**
	 * 获取@当前用户的微博列表 
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
    	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
        try {
        	Weibo weibo = getWeibo(false,args);
        	List<Status> list = weibo.getMentions();
        	for(Status status : list) {
        		System.out.println( status.getId() + "  : "+status.getText());
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Weibo getWeibo(boolean isOauth,String ... args) {
		Weibo weibo = new Weibo();
		if(isOauth) {//oauth验证方式 args[0]:访问的token；args[1]:访问的密匙
			weibo.setToken(args[0], args[1]);
			
		}else {//用户登录方式
    		weibo.setUserId(args[0]);//用户名/ID
    		weibo.setPassword(args[1]);//密码
		}
		return weibo;
	}
}
