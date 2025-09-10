module com.example.paskolosskaiciuokle {
    requires javafx.controls;
    requires javafx.fxml;

    // Open and export the main package for JavaFX
    opens com.example.paskolosskaiciuokle to javafx.fxml;
    exports com.example.paskolosskaiciuokle;

    // Open and export the Loan package for JavaFX
    opens Loan to javafx.fxml;
    exports Loan;
}