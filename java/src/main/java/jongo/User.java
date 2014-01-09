package jongo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private String name;
	
	private String lang;
	
	@JsonProperty("followers_count")
	private int followersCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lang=" + lang + ", followersCount="
				+ followersCount + "]";
	}
	
}
