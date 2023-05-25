package server.editor;

import org.jsoup.Jsoup;

import spark.Request;
import spark.Response;
import spark.Route;

// POST
public class Save implements Route {

	@Override
	public Object handle(Request req, Response res) throws Exception {
		System.out.println("\nSave ----");

		String content = req.queryParams("contentDE");
		if (content == null) {
			throw new RuntimeException("content is null");
		}
		System.out.println(prettyHTML(content));
		
		return "<html><body>ok, saved. <a href=editor.html>editor.html</a></body></html>";
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
