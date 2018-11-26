package table;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;

public class MedicamentsTableControl {

  private MedicamentsTableControl() {
  }

  public static void setWidth(GridPane pane, TableColumn pharmacyName, TableColumn pharmacyCity, TableColumn pharmacyStreet, TableColumn pharmacyStreetNumber, TableColumn pharmacyPhone,
      TableColumn medicamentPrce) {
    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
      pharmacyName.setPrefWidth(newSceneWidth.doubleValue() * ((100d / 6d) / 100d));
      pharmacyCity.setPrefWidth(newSceneWidth.doubleValue() * ((100d / 6d) / 100d));
      pharmacyStreet.setPrefWidth(newSceneWidth.doubleValue() * ((100d / 6d) / 100d));
      pharmacyStreetNumber.setPrefWidth(newSceneWidth.doubleValue() * ((100d / 6d) / 100d));
      pharmacyPhone.setPrefWidth(newSceneWidth.doubleValue() * ((100d / 6d) / 100d));
      medicamentPrce.setPrefWidth(newSceneWidth.doubleValue() * ((100d / 6d) / 100d));
    });
  }

}
