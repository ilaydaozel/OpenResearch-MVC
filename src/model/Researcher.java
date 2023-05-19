package model;

import java.util.*;

@SuppressWarnings("deprecation")
public class Researcher extends java.util.Observable{
	private String username;
	private String password;
	private List<Object> followingResearchers;
	private List<Object> followerResearchers;
	private List<Object> readingLists;
	
	
	public Researcher(String username, String password) {
		this.username = username;
		this.password = password;
		this.followingResearchers = new ArrayList<>();
		this.followerResearchers = new ArrayList<>();
		this.readingLists = new ArrayList<>();
		
	};
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
		setChanged();	
		notifyObservers();
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		setChanged();	
		notifyObservers();
	}

	public void follow(Researcher researcher) {
		this.followingResearchers.add(researcher.getUsername());
		researcher.getFollowerResearchers().add(username);
		System.out.println(this.username + " Followed " + researcher.getUsername());
		System.out.println(this.username + " Following list " + this.followingResearchers.toString());
		setChanged();	
		notifyObservers();
	}
		
	public void unfollow(Researcher researcher) {
		this.followingResearchers.remove(researcher.getUsername());
		researcher.getFollowerResearchers().remove(username);
		System.out.println(this.username + " Unfollowed " + researcher.getUsername());
		System.out.println(this.username + " Follower list " + this.followingResearchers.toString());
		setChanged();	
		notifyObservers();
	}
	
	public void addNewReadingList(String name) {
		readingLists.add(new ReadingList(name, this));
	}
	
	public void removeReadingList(ReadingList readingList) {
		readingLists.remove(readingList);
	}
	public String toString() {
		return username;
	}
	public List<Object> getFollowingResearchers() {
		return followingResearchers;
	}
	public void setFollowingResearchers(List<Object> followingResearchers) {
		this.followingResearchers = followingResearchers;
	}
	public List<Object> getFollowerResearchers() {
		return followerResearchers;
	}
	public void setFollowerResearchers(List<Object> followerResearchers) {
		this.followerResearchers = followerResearchers;
	}
	public List<Object> getReadingLists() {
		return readingLists;
	}
	public void setReadingLists(List<Object> readingLists) {
		this.readingLists = readingLists;
	}
	
}
