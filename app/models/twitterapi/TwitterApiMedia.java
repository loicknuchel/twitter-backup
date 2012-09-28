package models.twitterapi;

import java.util.Arrays;

public class TwitterApiMedia {
	public Long id;
	public String id_str;
	public Integer[] indices;
	public String media_url;
	public String media_url_https;
	public String url;
	public String display_url;
	public String expanded_url;
	public String type; // ex: photo
	public TwitterApiSizes sizes;

	@Override
	public String toString() {
		return "TwitterApiMedia [id=" + id + ", id_str=" + id_str + ", indices=" + Arrays.toString(indices) + ", media_url=" + media_url + ", media_url_https="
				+ media_url_https + ", url=" + url + ", display_url=" + display_url + ", expanded_url=" + expanded_url + ", type=" + type + ", sizes=" + sizes
				+ "]";
	}
}
