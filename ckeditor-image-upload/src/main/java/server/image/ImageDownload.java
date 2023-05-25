package server.image;

import java.io.File;
import java.io.FileInputStream;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.utils.IOUtils;

// After uploading an image CKeditor directly downloads the image.
public class ImageDownload implements Route {
	public static final String DOWNLOAD = "/image-download";

	@Override
	public Object handle(Request req, Response res) throws Exception {
		System.out.println("\nImageDownload ----");
		String dn = req.queryParams("dn");
		System.out.println("\t" + dn);
		File file = new File(ImageUpload.IMAGE_FOLDER + dn);
		if (!file.isFile()) {
			throw new RuntimeException("File not found: " + file.getAbsolutePath());
		}
		System.out.println("\t" + file.getAbsolutePath());
		try (FileInputStream fis = new FileInputStream(file)) {
			IOUtils.copy(fis, res.raw().getOutputStream());
		}
		return null;
	}
}
