package com.docusign.hackathon.controller;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TestTwitter {

//	public static void main(String args[]) throws Exception{
	    // The factory instance is re-useable and thread safe.
	    /*Twitter twitter = TwitterFactory.getSingleton();
	    twitter.setOAuthConsumer("uI0rvuvB2LOV2qHD5GcyEhwJN", "jIyGfMyaiBjvF3VdC8eTNmAOW2S8R7Tvx6wSlpuvh9efjJtK0r");
	    
	    
	    RequestToken requestToken = twitter.getOAuthRequestToken();
	    AccessToken accessToken = null;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while (null == accessToken) {
	      System.out.println("Open the following URL and grant access to your account:");
	      System.out.println(requestToken.getAuthorizationURL());
	      System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
	      String pin = br.readLine();
	      try{
	         if(pin.length() > 0){
	           accessToken = twitter.getOAuthAccessToken(requestToken, pin);
	         }else{
	           accessToken = twitter.getOAuthAccessToken();
	         }
	      } catch (TwitterException te) {
	        if(401 == te.getStatusCode()){
	          System.out.println("Unable to get the access token.");
	        }else{
	          te.printStackTrace();
	        }
	      }
	    }
	    //persist to the accessToken for future reference.
	    
//	    twitter.verifyCredentials();
	    
	    Paging paging = new Paging();
	    paging.setCount(1);
	    ResponseList<Status> userTimeLineList = twitter.getUserTimeline(paging);
	    for(Status stat: userTimeLineList){
	    	System.out.println("TestTwitter.main() " + stat);
	    }
//	    Status status = twitter.updateStatus(args[0]);
//	    System.out.println("Successfully updated the status to [" + status.getText() + "].");
	    System.exit(0);*/
		
		public static void main(String args[]) throws Exception{
		    // The factory instance is re-useable and thread safe.
		    TwitterFactory factory = new TwitterFactory();
		    AccessToken accessToken = loadAccessToken(1);
		    Twitter twitter = factory.getInstance();
		    twitter.setOAuthConsumer("uI0rvuvB2LOV2qHD5GcyEhwJN", "jIyGfMyaiBjvF3VdC8eTNmAOW2S8R7Tvx6wSlpuvh9efjJtK0r");
		    twitter.setOAuthAccessToken(accessToken);
		    
		    System.out.println("TestTwitter.main()");
		    Paging paging = new Paging();
		    paging.setCount(1);
		    ResponseList<Status> userTimeLineList = twitter.getUserTimeline(paging);
		    for(Status stat: userTimeLineList){
		    	System.out.println("TestTwitter.main() " + stat.getText());
		    }
		    
		    System.exit(0);
		  }
		  private static AccessToken loadAccessToken(int useId){
		    String token = "961256536759676928-uIxDD2eJmJxsGANCquw8BbsLhOcwEn2";
		    String tokenSecret = "ueFOQjrbsp4oylhIGp4WfNFTp5Pg5cvy1Nu8NsgUd1F6h";
		    return new AccessToken(token, tokenSecret);
		  }
//	  }

}
