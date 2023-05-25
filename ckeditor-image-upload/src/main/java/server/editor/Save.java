package server.editor;

import org.jsoup.Jsoup;

import spark.Request;
import spark.Response;
import spark.Route;

// POST
// Receives the editor content
// see editor.html line 49
public class Save implements Route {

	@Override
	public Object handle(Request req, Response res) throws Exception {
		System.out.println("\nSave ----");

		String content = req.queryParams("contentDE");
		if (content == null) {
			throw new RuntimeException("content is null");
		}
		System.out.println(prettyHTML(content));
		
		return "ok, saved";
	}
	
	public static String prettyHTML(String html) {
		// https://mkyong.com/java/java-pretty-print-html/
		try {
			return Jsoup.parse(html).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return html;
		}
	}
}
