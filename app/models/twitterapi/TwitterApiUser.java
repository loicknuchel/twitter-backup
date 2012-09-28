package models.twitterapi;

public class TwitterApiUser {
	public Long id;
	public String id_str;
	public String name;
	public String screen_name;
	public String location;
	public String url;
	public String description;
	// public Boolean protected;
	public Integer followers_count;
	public Integer friends_count;
	public Integer listed_count;
	public String created_at;
	public Integer favourites_count;
	public String utc_offset;
	public String time_zone;
	public Boolean geo_enabled;
	public Boolean verified;
	public Integer statuses_count;
	public String lang;
	public Boolean contributors_enabled;
	public Boolean is_translator;
	public String profile_background_color;
	public String profile_background_image_url;
	public String profile_background_image_url_https;
	public Boolean profile_background_tile;
	public String profile_image_url;
	public String profile_image_url_https;
	public String profile_link_color;
	public String profile_sidebar_border_color;
	public String profile_sidebar_fill_color;
	public String profile_text_color;
	public Boolean profile_use_background_image;
	public Boolean default_profile;
	public Boolean default_profile_image;
	public String following;
	public String follow_request_sent;
	public String notifications;

	@Override
	public String toString() {
		return "TwitterApiUser [id=" + id + ", id_str=" + id_str + ", name=" + name + ", screen_name=" + screen_name + ", location=" + location + ", url="
				+ url + ", description=" + description + ", followers_count=" + followers_count + ", friends_count=" + friends_count + ", listed_count="
				+ listed_count + ", created_at=" + created_at + ", favourites_count=" + favourites_count + ", utc_offset=" + utc_offset + ", time_zone="
				+ time_zone + ", geo_enabled=" + geo_enabled + ", verified=" + verified + ", statuses_count=" + statuses_count + ", lang=" + lang
				+ ", contributors_enabled=" + contributors_enabled + ", is_translator=" + is_translator + ", profile_background_color="
				+ profile_background_color + ", profile_background_image_url=" + profile_background_image_url + ", profile_background_image_url_https="
				+ profile_background_image_url_https + ", profile_background_tile=" + profile_background_tile + ", profile_image_url=" + profile_image_url
				+ ", profile_image_url_https=" + profile_image_url_https + ", profile_link_color=" + profile_link_color + ", profile_sidebar_border_color="
				+ profile_sidebar_border_color + ", profile_sidebar_fill_color=" + profile_sidebar_fill_color + ", profile_text_color=" + profile_text_color
				+ ", profile_use_background_image=" + profile_use_background_image + ", default_profile=" + default_profile + ", default_profile_image="
				+ default_profile_image + ", following=" + following + ", follow_request_sent=" + follow_request_sent + ", notifications=" + notifications
				+ "]";
	}
}
