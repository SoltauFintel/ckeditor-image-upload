package server.editor;

import spark.Request;
import spark.Response;
import spark.Route;

// form action GET
public class FormAction implements Route {

	@Override
	public Object handle(Request req, Response res) throws Exception {
		System.out.println("\nFormAction ----");
		// Here you can wait for the POST (Save.java), save all data and send a redirect.
		return "<html><body><h3>FormAction ok</h3><p><a href=editor.html>editor.html</a></p></body></html>";
	}
}
