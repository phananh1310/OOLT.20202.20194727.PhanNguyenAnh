package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private ToggleGroup Tools;
    private Color color;
    private int circleSize;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(),event.getY(),circleSize,color);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void erase(ActionEvent event) {
    	color = Color.WHITE;
    	circleSize=16;
    }

    @FXML
    void draw(ActionEvent event) {
    	color = Color.BLACK;
    	circleSize=4;
    }
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    	
    }

}
