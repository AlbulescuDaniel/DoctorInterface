package table;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
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

  public static void setHeight(GridPane pane, RowConstraints createPrescriptionComponentsGridRow, ScrollPane createPrescriptionScrollPane,
      GridPane createPrescriptionGridPane, AnchorPane createPrescriptionAnchorPane) {
    pane.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {

      if (createPrescriptionComponentsGridRow.getPrefHeight() <= 560) {
        if (createPrescriptionComponentsGridRow.getPrefHeight() < 400) {
          createPrescriptionGridPane.setPrefHeight(400);
          createPrescriptionComponentsGridRow.setPrefHeight(400);
          createPrescriptionScrollPane.setPrefHeight(400);
          createPrescriptionAnchorPane.setPrefHeight(400);
        }
        else {
          createPrescriptionGridPane.setPrefHeight(540);
          createPrescriptionComponentsGridRow.setPrefHeight(540);
          createPrescriptionScrollPane.setPrefHeight(540);
          createPrescriptionAnchorPane.setPrefHeight(540);
        }
      }
    });
  }
}
