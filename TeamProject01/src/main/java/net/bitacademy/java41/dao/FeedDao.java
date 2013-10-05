package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.Feed;

public interface FeedDao {
	public List<Feed> list(int pno) throws Exception;
	public List<Feed> listAll() throws Exception;
	public int add(Feed feed) throws Exception;
	public Feed get(int fno) throws Exception;
	public void update(Feed feed) throws Exception ;	
	public int remove(int feedNo) throws Exception ;
	void alterDelete();
}
