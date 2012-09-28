package models.twitterapi;

import java.util.Arrays;

public class TwitterApiMention {
	public String screen_name;
	public String name;
	public Long id;
	public String id_str;
	public Integer[] indices;

	@Override
	public String toString() {
		return "TwitterApiMention [screen_name=" + screen_name + ", name=" + name + ", id=" + id + ", id_str=" + id_str + ", indices="
				+ Arrays.toString(indices) + "]";
	}
}
