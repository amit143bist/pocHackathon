package com.docusign.hackathon.service;

import org.springframework.stereotype.Service;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Service
public class TwitterService {

	public Status fetchTwitterMessage() {

		TwitterFactory factory = new TwitterFactory();
		AccessToken accessToken = loadIndividualAccessToken();
		Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer("uI0rvuvB2LOV2qHD5GcyEhwJN", "jIyGfMyaiBjvF3VdC8eTNmAOW2S8R7Tvx6wSlpuvh9efjJtK0r");
		twitter.setOAuthAccessToken(accessToken);

		Paging paging = new Paging();
		paging.setCount(1);
		ResponseList<Status> userTimeLineList = null;

		Status status = null;
		try {
			userTimeLineList = twitter.getUserTimeline(paging);
			status = userTimeLineList.get(0);
		} catch (TwitterException e) {
			e.printStackTrace();
		}

		return status;
	}

	private static AccessToken loadIndividualAccessToken() {
		String token = "961256536759676928-uIxDD2eJmJxsGANCquw8BbsLhOcwEn2";
		String tokenSecret = "ueFOQjrbsp4oylhIGp4WfNFTp5Pg5cvy1Nu8NsgUd1F6h";
		return new AccessToken(token, tokenSecret);
	}

	public void postTwitterMessage(String twitterPostMessage) {

		TwitterFactory factory = new TwitterFactory();
		AccessToken accessToken = loadAccessTokenForCorp(1);
		Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer("hJHza0hloY3YDY7YexAK48C7t", "yrjmpFaySNS2nooUULdKmhOnhBmr8ivJWNXY2Munr65gu85lCV");
		twitter.setOAuthAccessToken(accessToken);

		try {
			twitter.updateStatus(twitterPostMessage);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private static AccessToken loadAccessTokenForCorp(int useId) {
		String token = "961423566720782336-fl7Hv6XOoEzSGbjdecGeGNCMuQV5lsY";
		String tokenSecret = "cv8byVXpQ56WkJDwEPDOBnX8PHj89coqH33gj3xKprD6I";
		return new AccessToken(token, tokenSecret);
	}
}