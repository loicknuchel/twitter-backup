package controllers;

import java.util.List;

import models.Twitt;
import models.twitterapi.TwitterApiTwitt;
import play.mvc.Controller;
import play.mvc.Result;
import services.TwitterApi;

public class Application extends Controller {

	public static Result timeline() {
		String title = "Timeline";
		List<Twitt> twitts = Twitt.all();
		// for (Twitt twitt : twitts) {
		// System.out.println("Twitt from " + twitt.user.screenName);
		// }

		return ok(views.html.timeline.render(title, twitts));
	}

	public static Result loadTwitts() {
		TwitterApiTwitt[] timeline = TwitterApi.getTimeline("mock");
		for (TwitterApiTwitt twitt : timeline) {
			Twitt.create(new Twitt(twitt));
		}
		System.out.println(timeline.length + " TWITT CREATED");
		return redirect(routes.Application.timeline());
	}

	public static Result index() {
		String title = "Welcome to TwitterBackup";

		// TwitterApiTwitt twitt = TwitterApi.getTwitt("mock");
		// if (twitt != null) {
		// title = twitt.text;
		// System.out.println("\nTWITT :");
		// System.out.println(twitt);
		// }
		//
		// TwitterApiUser user = TwitterApi.getUserProfile("mock");
		// if (user != null) {
		// title = user.name;
		// System.out.println("\nUSER :");
		// System.out.println(user);
		// }
		//
		// TwitterApiTwitt[] timeline = TwitterApi.getTimeline("mock");
		// if (timeline != null) {
		// title = "timeline of " + timeline.length + " twitts";
		// System.out.println("\nTIMELINE :");
		// // System.out.println(Arrays.toString(timeline));
		// System.out.println(timeline);
		// }

		return ok(views.html.index.render(title));
	}

	public static Result welcome() {
		return ok(views.html.welcome.render("This is the Play 2 welcome page."));
	}

}