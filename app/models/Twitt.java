package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import models.twitterapi.TwitterApiHashtag;
import models.twitterapi.TwitterApiMention;
import models.twitterapi.TwitterApiTwitt;
import models.twitterapi.TwitterApiUrl;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Twitt extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	public Long id;
	@Required
	public String text;
	@Required
	@ManyToOne(fetch = FetchType.EAGER)
	public User user;
	public String createdAt;
	public Boolean truncated;
	public Long inReplyToStatusId;
	public Long inReplyToUserId;
	public String inReplyToScreenName;
	public Integer retweetCount;
	public Boolean favorited;
	public Boolean retweeted;
	public List<String> hashtags;
	@ManyToMany
	public List<Url> urls;
	@ManyToMany
	public List<Mention> mentions;

	public Twitt(TwitterApiTwitt twitt) {
		this.id = twitt.id;
		this.text = twitt.text;
		this.user = new User(twitt.user);
		this.createdAt = twitt.created_at;
		this.truncated = twitt.truncated;
		this.inReplyToStatusId = twitt.in_reply_to_status_id;
		this.inReplyToUserId = twitt.in_reply_to_user_id;
		this.inReplyToScreenName = twitt.in_reply_to_screen_name;
		this.retweetCount = twitt.retweet_count;
		this.favorited = twitt.favorited;
		this.retweeted = twitt.retweeted;
		if (twitt.entities != null) {
			if (twitt.entities.hashtags != null) {
				this.hashtags = new ArrayList<String>();
				for (TwitterApiHashtag hashtag : twitt.entities.hashtags) {
					hashtags.add(hashtag.text);
				}
			}
			if (twitt.entities.urls != null) {
				this.urls = new ArrayList<Url>();
				for (TwitterApiUrl url : twitt.entities.urls) {
					urls.add(new Url(url));
				}
			}
			if (twitt.entities.user_mentions != null) {
				this.mentions = new ArrayList<Mention>();
				for (TwitterApiMention mention : twitt.entities.user_mentions) {
					mentions.add(new Mention(mention));
				}
			}
		}
	}

	public static Finder<Long, Twitt> find = new Finder<Long, Twitt>(Long.class, Twitt.class);

	public static List<Twitt> all() {
		return find.all();
	}

	public static Twitt byId(Long id) {
		return find.ref(id);
	}

	public static void create(Twitt twitt) {
		if (Twitt.find.byId(twitt.id) == null) {
			System.out.println("Create twitt " + twitt.id);
			if (twitt.user != null) {
				if (User.byId(twitt.user.id) == null) {
					User.create(twitt.user);
				} else {
					System.out.println("User " + twitt.user.id + " already exist");
				}
			}
			if (twitt.urls != null) {
				for (Url url : twitt.urls) {
					if (Url.byUrl(url.url) == null) {
						Url.create(url);
					} else {
						System.out.println("Url " + url.url + " already exist");
					}
				}
			}
			if (twitt.mentions != null) {
				for (Mention mention : twitt.mentions) {
					if (Mention.byUserId(mention.userId) == null) {
						Mention.create(mention);
					} else {
						System.out.println("Mention " + mention.userId + " already exist");
					}
				}
			}
			twitt.save();
		} else {
			System.out.println("Twitt " + twitt.id + " already exist");
		}
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
