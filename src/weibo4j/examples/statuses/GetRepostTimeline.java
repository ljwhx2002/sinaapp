/**
 * 
 */
package weibo4j.examples.statuses;

import java.util.List;

import weibo4j.Status;
import weibo4j.Weibo;

/**
 * @author haidong
 *
 */
public class GetRepostTimeline {

	/**
	 * 返回一条原创微博消息的最新n条转发微博消息。本接口无法对非原创微博进行查询。 
     * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
    	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
        try {
        	Weibo weibo = getWeibo(false,args);
        	List <Status> list =  weibo.getreposttimeline("4052124813");
        	for(Status status:list){
        	System.out.println(status.toString());
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Weibo getWeibo(boolean isOauth,String ... args) {
		Weibo weibo = new Weibo();
		if(isOauth) {
			weibo.setToken(args[0], args[1]);
			
		}else {
    		weibo.setUserId(args[0]);
    		weibo.setPassword(args[1]);
		}
		return weibo;
	}

}