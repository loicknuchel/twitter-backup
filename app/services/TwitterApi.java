package services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import models.twitterapi.MockTwitterApi;
import models.twitterapi.TwitterApiTwitt;
import models.twitterapi.TwitterApiUser;
import utils.WebFile;

import com.google.gson.Gson;

public class TwitterApi {
	private static final String GET_TWITT_URL = "http://api.twitter.com/1/statuses/show.json?id=%ID_STR%&include_entities=1";
	private static final String GET_USER_URL = "http://api.twitter.com/1/users/show.json?user_id=%USER_ID%";
	private static final String GET_TIMELINE_URL = "http://api.twitter.com/1/statuses/user_timeline/%USER_ID%.json?include_entities=1&include_rts=1";

	public static TwitterApiTwitt getTwitt(String id_str) {
		TwitterApiTwitt apiTwitt = null;
		if (id_str.equals("mock")) {
			Gson gson = new Gson();
			apiTwitt = gson.fromJson(MockTwitterApi.SAMPLE_TWITT_JSON, TwitterApiTwitt.class);
		} else {
			String json = getJsonContent(getTwittUrl(id_str));
			if (json != null) {
				Gson gson = new Gson();
				apiTwitt = gson.fromJson(json, TwitterApiTwitt.class);
			}
		}
		return apiTwitt;
	}

	public static TwitterApiUser getUserProfile(String user_id_str) {
		TwitterApiUser apiUser = null;
		if (user_id_str.equals("mock")) {
			Gson gson = new Gson();
			apiUser = gson.fromJson(MockTwitterApi.SAMPLE_USER_PROFILE_JSON, TwitterApiUser.class);
		} else {
			String json = getJsonContent(getUserUrl(user_id_str));
			if (json != null) {
				Gson gson = new Gson();
				apiUser = gson.fromJson(json, TwitterApiUser.class);
			}
		}
		return apiUser;
	}

	public static TwitterApiTwitt[] getTimeline(String user_id_str, Integer count, String maxId) {
		TwitterApiTwitt[] apiTimeline = null;
		if (user_id_str.equals("mock")) {
			Gson gson = new Gson();
			apiTimeline = gson.fromJson(MockTwitterApi.SAMPLE_TIMELINE_10_JSON, TwitterApiTwitt[].class);
		} else {
			String json = getJsonContent(getTimelineUrl(user_id_str, count, maxId));
			if (json != null) {
				Gson gson = new Gson();
				apiTimeline = gson.fromJson(json, TwitterApiTwitt[].class);
			}
		}
		return apiTimeline;
	}

	public static TwitterApiTwitt[] getTimeline(String user_id) {
		return getTimeline(user_id, null, null);
	}

	private static String getJsonContent(String url) {
		String json = null;
		try {
			WebFile file = new WebFile(url);
			int responseCode = file.getResponseCode();
			String MIMEType = file.getMIMEType();
			Object content = file.getContent();
			if (responseCode == 200 && "application/json".equals(MIMEType) && content instanceof String) {
				json = (String) content;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	private static String getTwittUrl(String id_str) {
		return GET_TWITT_URL.replace("%ID_STR%", id_str);
	}

	private static String getUserUrl(String user_id_str) {
		return GET_USER_URL.replace("%USER_ID%", user_id_str);
	}

	private static String getTimelineUrl(String user_id_str, Map<String, String> params) {
		String url = GET_TIMELINE_URL.replace("%USER_ID%", user_id_str);
		if (params != null) {
			for (Entry<String, String> entry : params.entrySet()) {
				if (entry != null && entry.getKey() != null && entry.getValue() != null) {
					url += "&" + entry.getKey() + "=" + entry.getValue();
				}
			}
		}
		return url;
	}

	private static String getTimelineUrl(String user_id_str, Integer count, String maxId) {
		Map<String, String> params = new HashMap<String, String>();
		if (count != null && count > 0 && count <= 200) {
			params.put("count", count.toString());
		}
		if (maxId != null) {
			params.put("max_id", maxId);
		}
		return getTimelineUrl(user_id_str, params);
	}
}
