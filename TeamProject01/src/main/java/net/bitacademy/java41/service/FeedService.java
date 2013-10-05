package net.bitacademy.java41.service;

import java.util.List;

import net.bitacademy.java41.vo.Feed;

public interface FeedService {
	public List<Feed> getFeedList(int pno) throws Exception;
	public List<Feed> getFeedAllList() throws Exception;
	public int addFeed(Feed f) throws Exception;
	public Feed getFeed(int fno) throws Exception;
	public void updateFeed(Feed f) throws Exception;
	public void removeFeed(int feedNo) throws Exception;
}
