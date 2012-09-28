package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import models.twitterapi.TwitterApiUrl;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "url" }))
public class Url extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Required
	public String url;
	public String expandedUrl;
	public String displayUrl;

	public Url(TwitterApiUrl url) {
		this.url = url.url;
		this.expandedUrl = url.expanded_url;
		this.displayUrl = url.display_url;
	}

	public static Finder<Long, Url> find = new Finder<Long, Url>(Long.class, Url.class);

	public static List<Url> all() {
		return find.all();
	}

	public static Url byId(Long id) {
		return find.ref(id);
	}

	public static Url byUrl(String url) {
		return find.where().eq("url", url).findUnique();
	}

	public static void create(Url url) {
		System.out.println("Create url " + url.id);
		url.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
