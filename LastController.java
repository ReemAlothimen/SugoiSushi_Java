package sugoisushi.SugoiSushi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author alothimen
 */
public class LastController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button exitBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        if(event.getSource() == exitBtn){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("\nGoodbye!\n");
            stage.close();
        }
        
    }

    
}
