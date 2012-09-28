package models.twitterapi;

import java.util.Arrays;

public class TwitterApiUrl {
	public String url;
	public String expanded_url;
	public String display_url;
	public Integer[] indices;

	@Override
	public String toString() {
		return "TwitterApiUrl [url=" + url + ", expanded_url=" + expanded_url + ", display_url=" + display_url + ", indices=" + Arrays.toString(indices) + "]";
	}
}
