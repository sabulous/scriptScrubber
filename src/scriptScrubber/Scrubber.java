/*
 * Muhammed Sabri Sahin
 * 03.04.2019
 * 
 * Simple <script>...</script> block remover with JavaFX
 * 
 */

package scriptScrubber;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scrubber extends Application {
	
	static final String openTag = "<script";
	static final String closeTag = "</script>";
	
	public static String scrub(String text) {
		if(text == null) return "";
		
		String scrubbedText = text;
		
		for(int start = scrubbedText.indexOf(openTag), end = scrubbedText.indexOf(closeTag) + closeTag.length();
				start >= 0 && end >= (start + openTag.length() + closeTag.length());
				start = scrubbedText.indexOf(openTag), end = scrubbedText.indexOf(closeTag) + closeTag.length()) {
				scrubbedText = scrubbedText.replace(scrubbedText.substring(start, end), "");
		}

		return scrubbedText;
	}

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = (VBox) FXMLLoader.load(getClass().getResource("SGUI.fxml"));
		// Create the Scene
        Scene scene = new Scene(root,800,400);
        // Set the Title to the Stage
        primaryStage.setTitle("Script Scrubber v1.0");
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Show the Stage
        primaryStage.show();
	}
}
