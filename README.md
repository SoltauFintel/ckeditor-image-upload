# WYSIWYG HTML editor with image upload

**[CKEditor 5](https://ckeditor.com/) with [image upload](https://ckeditor.com/docs/ckeditor5/latest/framework/deep-dive/upload-adapter.html#the-complete-implementation)
feature.** Backend is developed with Java 17 and web framework [Spark](https://sparkjava.com).

This demo uses Gradle 7.4.2 and Eclipse 2023-03.

Clone this repo into your Eclipse and run Server.java. Call http://localhost:8080 in your Chrome browser and navigate to editor.html. Then insert an image. After inserting
an image into the editor it will be uploaded (and also downloaded) to the Java backend. The editor content is also posted to the server, but not saved.
