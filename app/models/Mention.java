package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import models.twitterapi.TwitterApiMention;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
// @Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "screen_name" }), @UniqueConstraint(columnNames = { "user_id" }) })
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "user_id" }))
public class Mention extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	@Required
	public String screenName;
	public String name;
	@Required
	public Long userId;

	public Mention(TwitterApiMention mention) {
		this.screenName = mention.screen_name;
		this.name = mention.name;
		this.userId = mention.id;
	}

	public static Finder<Long, Mention> find = new Finder<Long, Mention>(Long.class, Mention.class);

	public static List<Mention> all() {
		return find.all();
	}

	public static Mention byId(Long id) {
		return find.ref(id);
	}

	public static Mention byUserId(Long userId) {
		return find.where().eq("userId", userId).findUnique();
	}

	public static void create(Mention mention) {
		System.out.println("Create mention " + mention.id);
		mention.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
