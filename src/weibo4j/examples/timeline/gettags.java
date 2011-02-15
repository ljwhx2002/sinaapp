/**
 * 
 */
package weibo4j.examples.timeline;

import java.util.List;
import weibo4j.Status;
import weibo4j.Tag;
import weibo4j.Weibo;
import weibo4j.org.json.JSONObject;

/**
 * @author haidong
 *
 */
public class gettags{

	/**
	 * 获取tags；
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
    	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
        try {
        	Weibo weibo = getWeibo(true,args);
        	List<Tag> tag= weibo.createTags("Is1988");
        	 for(Tag t:tag){
        		System.out.println( tag.toString());
        	 }
        	List<Tag> gettags=weibo.gettags("1377583044");
        	for(Tag status : gettags) {
        		System.out.println( status.toString());
        	}
        	List<Tag>gets=weibo.getSuggestions();
        	for(Tag status: gets){
        		System.out.println(status.toString());
        	}
        	JSONObject destroytag=weibo.destoryTag("221012190002198508");
        	List<Tag> list =  (List<Tag>) weibo.destory_batchTags("221012190002198508");
        	for(Tag status : list) {
        		System.out.println( status.toString());
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