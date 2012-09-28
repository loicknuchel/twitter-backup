package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import models.twitterapi.TwitterApiUser;
import play.db.ebean.Model;

@Entity
public class User extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	public Long id;
	public String name;
	public String screenName;
	public String url;
	public String description;
	public Integer followersCount;
	public Integer friendsCount;
	public Integer listedCount;
	public String createdAt;
	public Integer favouritesCount;
	public Integer statusesCount;
	public String profileImageUrl;
	@OneToMany(mappedBy = "user")
	public List<Twitt> twitts;

	public User(TwitterApiUser user) {
		this.id = user.id;
		this.name = user.name;
		this.screenName = user.screen_name;
		this.url = user.url;
		this.description = user.description;
		this.followersCount = user.followers_count;
		this.friendsCount = user.friends_count;
		this.listedCount = user.listed_count;
		this.createdAt = user.created_at;
		this.favouritesCount = user.favourites_count;
		this.statusesCount = user.statuses_count;
		this.profileImageUrl = user.profile_image_url;
	}

	public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

	public static List<User> all() {
		return find.all();
	}

	public static User byId(Long id) {
		// return find.ref(id);
		return find.byId(id);
	}

	public static void create(User user) {
		System.out.println("Create user " + user.id);
		user.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
