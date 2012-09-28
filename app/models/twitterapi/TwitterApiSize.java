package models.twitterapi;

public class TwitterApiSize {
	public Integer w;
	public Integer h;
	public String resize; // ex: fit

	@Override
	public String toString() {
		return "TwitterApiSize [w=" + w + ", h=" + h + ", resize=" + resize + "]";
	}
}
