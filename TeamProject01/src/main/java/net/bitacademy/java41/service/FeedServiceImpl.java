package net.bitacademy.java41.service;

import java.util.List;

import net.bitacademy.java41.dao.FeedDao;
import net.bitacademy.java41.vo.Feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedServiceImpl implements FeedService{
	@Autowired	FeedDao feedDao;

	@Override
	public List<Feed> getFeedList(int pno) throws Exception {
		return feedDao.list(pno);
	}

	@Override
	public int addFeed(Feed f) throws Exception {
		return feedDao.add(f);
	}

	@Override
	public void updateFeed(Feed f) throws Exception {
		
	}

	@Override
	public void removeFeed(int feedNo) throws Exception {
		feedDao.remove(feedNo);
	}

	@Override
	public Feed getFeed(int fno) throws Exception {
		return feedDao.get(fno);
	}

	@Override
	public List<Feed> getFeedAllList() throws Exception {
		return feedDao.listAll();
	}

}
