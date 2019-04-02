package scriptScrubber;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.VBox;

public class GUIController implements Initializable {

	@FXML private VBox rootContainer;
	
	@FXML private TextArea inputArea;
	@FXML private TextArea outputArea;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setupLayout();
		initExampleInput();
		
		EventHandler<InputEvent> inputChangeEvent = new EventHandler<InputEvent>() {
	
			@Override
			public void handle(InputEvent event) {
				outputArea.setText(Scrubber.scrub(inputArea.getText()));
			}
			
		};
		inputArea.addEventHandler(InputEvent.ANY, inputChangeEvent);		
	}

	private void initExampleInput() {
		inputArea.setText("Can you see the <script> TEXT HERE </script>, huh?");
	}

	private void setupLayout() {
		// sets margins for child nodes of root container
		for(Node node : rootContainer.getChildren()) {
			VBox.setMargin(node, new Insets(2, 2, 5, 2));
		}
		
		Tooltip inputTooltip = new Tooltip("Enter raw text here to be sanitized.");
		inputTooltip.setAutoHide(true);
		
		inputArea.setTooltip(inputTooltip);
		
		outputArea.setEditable(false);
	}

}
