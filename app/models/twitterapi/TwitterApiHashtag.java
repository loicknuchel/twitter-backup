package models.twitterapi;

import java.util.Arrays;

public class TwitterApiHashtag {
	public String text;
	public Integer[] indices;

	@Override
	public String toString() {
		return "TwitterApiHashtag [text=" + text + ", indices=" + Arrays.toString(indices) + "]";
	}
}
