package models.twitterapi;

import java.util.Arrays;

public class TwitterApiEntities {
	public TwitterApiHashtag[] hashtags;
	public TwitterApiUrl[] urls;
	public TwitterApiMention[] user_mentions;
	public TwitterApiMedia[] media;

	@Override
	public String toString() {
		return "TwitterApiEntities [hashtags=" + Arrays.toString(hashtags) + ", urls=" + Arrays.toString(urls) + ", user_mentions="
				+ Arrays.toString(user_mentions) + ", media=" + Arrays.toString(media) + "]";
	}
}
