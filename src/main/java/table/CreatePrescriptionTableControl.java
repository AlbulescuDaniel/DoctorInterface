package table;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class CreatePrescriptionTableControl {
  private CreatePrescriptionTableControl() {
  }

  public static void setWidth(GridPane pane, ColumnConstraints createPrescriptionGridColumn, GridPane createPrescriptionGridPane) {

    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
      createPrescriptionGridColumn.setPrefWidth(newSceneWidth.doubleValue() - 500);
      createPrescriptionGridPane.setPrefWidth(newSceneWidth.doubleValue() - 20);
    });
  }

  public static void setHeight(GridPane pane, RowConstraints createPrescriptionTableGridRow, RowConstraints createPrescriptionComponentsGridRow) {
    pane.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
      createPrescriptionTableGridRow.setPrefHeight(newSceneHeight.doubleValue() * 65 / 100);
      createPrescriptionComponentsGridRow.setPrefHeight(newSceneHeight.doubleValue() * 35 / 100);
    });
  }
}
