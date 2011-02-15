/**
 *
 */
package weibo4j.examples.statuses;

import weibo4j.Comment;
import weibo4j.Status;
import weibo4j.Weibo;

/**
 * @author sina
 *
 */
public class UpdateComment {

	/**
	 * 对一条微博信息进行评论
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
    	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
        try {
        	Weibo weibo = getWeibo(false,args);
        	Status status = weibo.updateStatus("adsad32432ladsad，，");
        	Thread.sleep(1000);
        	String sid = status.getId()+"";
        	Comment comment = weibo.updateComment("21332432", sid, null);
        	System.out.println(comment.getId() + " : " + comment.getText() + "  " + comment.getCreatedAt());
        	Thread.sleep(1000);
        	comment = weibo.updateComment("hfgu65765h", sid, null);
        	System.out.println(comment.getId() + " : " + comment.getText() + "  " + comment.getCreatedAt());
        	Thread.sleep(1000);
        	comment = weibo.updateComment("juytu587trytry45", sid, null);
        	System.out.println(comment.getId() + " : " + comment.getText() + "  " + comment.getCreatedAt());
        	Thread.sleep(1000);
        	comment = weibo.updateComment("bhdfgfy45fdghdf", sid, null);
        	System.out.println(comment.getId() + " : " + comment.getText() + "  " + comment.getCreatedAt());
        	Thread.sleep(1000);
        	comment = weibo.updateComment("nbnm,,./'", sid, null);
        	System.out.println(comment.getId() + " : " + comment.getText() + "  " + comment.getCreatedAt());
        	Thread.sleep(1000);
        	comment = weibo.updateComment("gdftgJKHUKJ", sid, null);
        	System.out.println(comment.getId() + " : " + comment.getText() + "  " + comment.getCreatedAt());
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
