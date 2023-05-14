package model;

import interfaces.Observer;
import interfaces.Observable;
import java.util.*;

public class Researcher implements Observable {
	private String name;
	private String password;
	private String[] followingResearcherNames;
	private String[] followerResearcherNames;
	private List<Observer> observers = new ArrayList<>();
	
	public Researcher() {
		this.name= "İlayda";
		this.password= "123";
		this.followerResearcherNames = new String[5];
		this.followingResearcherNames = new String[5];
	}
	public String getName() {
		System.out.println("get name / researcher");
		return name;
	}
	public void setName(String name) {
		System.out.println("set name / researcher");
		this.name = name;
		//setChanged();
		notifyObservers();
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getFollowingResearcherNames() {
		return followingResearcherNames;
	}
	public void setFollowingResearcherNames(String[] followingResearcherNames) {
		this.followingResearcherNames = followingResearcherNames;
	}
	public String[] getFollowerResearcherNames() {
		return followerResearcherNames;
	}
	public void setFollowerResearcherNames(String[] followerResearcherNames) {
		this.followerResearcherNames = followerResearcherNames;
	}
    public void addObserver(Observer observer) {
	   System.out.println("add observers / researcher");
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
    	System.out.println("notify observers / researcher");
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
