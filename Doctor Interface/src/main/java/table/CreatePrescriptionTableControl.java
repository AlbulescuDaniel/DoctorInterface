package table;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class CreatePrescriptionTableControl {
  private CreatePrescriptionTableControl() {
  }
  
  public static void setWidth(GridPane pane, ColumnConstraints createPrescriptionGridColumn, GridPane createPrescriptionGridPane) {
    
    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
      createPrescriptionGridColumn.setPrefWidth(newSceneWidth.doubleValue() - 600);
      createPrescriptionGridPane.setPrefWidth(newSceneWidth.doubleValue());
    });
  }
}
