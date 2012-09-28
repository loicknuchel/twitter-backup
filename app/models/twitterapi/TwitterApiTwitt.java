package models.twitterapi;

public class TwitterApiTwitt {
	public String created_at;
	public Long id;
	public String id_str;
	public String text;
	public String source;
	public Boolean truncated;
	public Long in_reply_to_status_id;
	public String in_reply_to_status_id_str;
	public Long in_reply_to_user_id;
	public String in_reply_to_user_id_str;
	public String in_reply_to_screen_name;
	public TwitterApiUser user;
	public String geo;
	public String coordinates;
	public String place;
	public String contributors;
	public TwitterApiTwitt retweeted_status;
	public Integer retweet_count;
	public TwitterApiEntities entities;
	public Boolean favorited;
	public Boolean retweeted;
	public Boolean possibly_sensitive;

	@Override
	public String toString() {
		return "TwitterApiTwitt [created_at=" + created_at + ", id=" + id + ", id_str=" + id_str + ", text=" + text + ", source=" + source + ", truncated="
				+ truncated + ", in_reply_to_status_id=" + in_reply_to_status_id + ", in_reply_to_status_id_str=" + in_reply_to_status_id_str
				+ ", in_reply_to_user_id=" + in_reply_to_user_id + ", in_reply_to_user_id_str=" + in_reply_to_user_id_str + ", in_reply_to_screen_name="
				+ in_reply_to_screen_name + ", user=" + user + ", geo=" + geo + ", coordinates=" + coordinates + ", place=" + place + ", contributors="
				+ contributors + ", retweeted_status=" + retweeted_status + ", retweet_count=" + retweet_count + ", entities=" + entities + ", favorited="
				+ favorited + ", retweeted=" + retweeted + ", possibly_sensitive=" + possibly_sensitive + "]";
	}
}
