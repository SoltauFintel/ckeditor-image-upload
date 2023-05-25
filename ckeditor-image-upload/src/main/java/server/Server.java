package server;

import server.editor.FormAction;
import server.editor.Save;
import server.image.ImageDownload;
import server.image.ImageUpload;
import spark.Spark;

public class Server {

	public static void main(String[] args) {
		Spark.port(8080);
		
		Spark.staticFileLocation("web");
		Spark.externalStaticFileLocation("src/main/resources/web");
		
		Spark.get("/", (req, res) -> "<html><body><h1>CKEditor with image upload</h1>"
				+ "<p><a href=editor.html>editor.html</a></p></body></html>");
		Spark.post("/save", new Save());
		Spark.get("/form-action", new FormAction());
		Spark.post("/image-upload", new ImageUpload());
		Spark.get(ImageDownload.DOWNLOAD, new ImageDownload());
		
		System.out.println("server ready on port 8080");
	}
}
