package sugoisushi.SugoiSushi;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author alothimen
 */
public class FXMLLoginController implements Initializable {

    public static final int maxCharLength = 30;
    public static final int maxNumLength = 10;
    public Label label;
    @FXML
    public TextField textName;
    @FXML
    public TextField textPhoneNum;
    @FXML
    public Button loginButton;
    @FXML
    public Button exitButton;
    @FXML
    private AnchorPane scenePane;
    
    Stage stage;
    Stage primaryStage;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        textName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String custName) {
                if (!custName.matches("\\sa-zA-Z*")) {
                    textName.setText(custName.replaceAll("[^\\sa-zA-Z]", ""));
                }

            }
        });

        textName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textName.getText().length() > maxCharLength) {
                    String s = textName.getText().substring(0, maxCharLength);
                    textName.setText(s);
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,
                            "ERROR: Max input is 30");
                }
            }
        });

        textPhoneNum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String phone) {
                if (!phone.matches("\\d*")) {
                    textPhoneNum.setText(phone.replaceAll("[^\\d]", ""));
                }
            }
        });

        textPhoneNum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textPhoneNum.getText().length() < maxNumLength) {
                    String s = (String) textPhoneNum.getText();
                    textPhoneNum.setText(s);
                }
            }
        });
    }

    @FXML
    public void handleLoginButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == loginButton) {
            if (textName.getText().isEmpty() || textPhoneNum.getText().isEmpty()
                    || textPhoneNum.getText().length() != maxNumLength) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Please enter correct input.");
            } else {
                JOptionPane.showMessageDialog(null, "Registration Successful!");
                
                String username = textName.getText();
                String contactNum = textPhoneNum.getText();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuDashboard.fxml"));	
                Object root = loader.load();	
		
		MenuDashboardController menuController = loader.getController();
		menuController.displayName(username, contactNum);
                Stage primaryStage = new Stage();
                Scene scene = new Scene((Parent) root);
                
                primaryStage.setTitle("Sugoi Sushi");
                primaryStage.setScene(scene);
                
                Image icon = new Image(getClass().getResourceAsStream("sushi.png"));
                primaryStage.getIcons().add(icon);
                
                primaryStage.show();
                stage = (Stage) scenePane.getScene().getWindow();
                stage.close();       
            }
        }
    }

    @FXML
    public void handleExitButtonAction(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sugoi Sushi");
        alert.setHeaderText("You are about to quit!");
        alert.setContentText("Do you want to exit? ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Goodbye!");
            stage.close();
        }
        
    }
    

}
