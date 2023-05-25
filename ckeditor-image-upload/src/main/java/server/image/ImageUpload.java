package server.image;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.utils.IOUtils;

// POST
// Receives uploaded image. Saves the image into folder 'images'.
// See also uploader.js line 32.
public class ImageUpload implements Route {
	private static int counter = 0;
	public static String IMAGE_FOLDER = "images/";

	@Override
	public Object handle(Request req, Response res) throws Exception {
		String fieldName = "upload"; // see uploader.js line 84
		req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(fieldName));
		System.out.println("\nImageUpload ----");
		res.type("application/json");

		Part part = req.raw().getPart("upload");
		String filename = part.getSubmittedFileName();
		System.out.println("\tupload filename: " + filename);
		String ext = ".png";
		if (filename != null) {
			int o = filename.lastIndexOf(".");
			if (o > 0) {
				ext = filename.substring(o);
			}
		}

		counter++;
		File file = new File(IMAGE_FOLDER + "image-" + counter + ext);
		file.getParentFile().mkdirs();
		try (FileOutputStream fos = new FileOutputStream(file)) {
			IOUtils.copy(part.getInputStream(), fos);
		}
		System.out.println("\tImageUpload saved: " + file.toString());

		// Response must be JSON, containing url field.
		Success ret = new Success();
		ret.setUrl(ImageDownload.DOWNLOAD + "?dn=" + file.getName());
		String json = new Gson().toJson(ret);
		System.out.println("\tImageUpload response: " + json);
		return json;
	}

	public static class Success {
		private String url;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
}
