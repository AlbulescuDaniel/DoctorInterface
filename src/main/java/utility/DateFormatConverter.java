package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

public class DateFormatConverter {

  private DateFormatConverter() {
  }

  public static void setConverter(DatePicker... datePickers) {
    for (DatePicker datePicker : datePickers) {
      datePicker.setConverter(new StringConverter<LocalDate>() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        @Override
        public String toString(LocalDate date) {
          if (date != null) {
            return dateFormatter.format(date);
          }
          else {
            return "";
          }
        }

        @Override
        public LocalDate fromString(String string) {
          if (string != null && !string.isEmpty()) {
            return LocalDate.parse(string, dateFormatter);
          }
          else {
            return null;
          }
        }
      });
     }
  }
}
