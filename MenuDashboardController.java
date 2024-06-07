package sugoisushi.SugoiSushi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.Action;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author alothimen
 */
public class MenuDashboardController implements Initializable {

    public int totalCost;

    public int TUNA_NIGIRI;
    public int SALMON_NIGIRI;
    public int SALMON_ROLL;
    public int CALI_MAKI;
    public int TAMAGOYAKI;
    public int MACK_NIGIRI;
    public int UNAGI_NIGIRI;
    public int SHIME_SABA;
    public int TAKO_NIGIRI;
    public int IKURA_NIGIRI;
    public int UNI_NIGIRI;
    public int TOBIKO_NIGIRI;
    public int GREEN_TEA;
    public int BLACK_TEA;

    @FXML
    CheckBox tunaNigiri;
    @FXML
    CheckBox salmonNigiri;
    @FXML
    CheckBox salmonRoll;
    @FXML
    CheckBox caliMaki;
    @FXML
    CheckBox tamago;
    @FXML
    CheckBox mackNigiri;
    @FXML
    CheckBox unagiNigiri;
    @FXML
    CheckBox shimeSaba;
    @FXML
    CheckBox takoNigiri;
    @FXML
    CheckBox ikuraNigiri;
    @FXML
    CheckBox uniNigiri;
    @FXML
    CheckBox tobikoNigiri;
    @FXML
    Button checkoutBtn;

    Stage stage;
    Stage primaryStage;
    AnchorPane scenePane;

    public String item1;
    public String item2;
    public String item3;
    public String item4;
    public String item5;
    public String item6;
    public String item7;
    public String item8;
    public String item9;
    public String item10;
    public String item11;
    public String item12;
    @FXML
    private Label nameLabel;
    @FXML
    private Label contact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    public void checkboxListener(ActionEvent e) {

        if (tunaNigiri.isSelected()) {
            item1 = "Tuna Nigiri \t\t";
            TUNA_NIGIRI = 39;

        }
        if (salmonNigiri.isSelected()) {
            item2 = "Salmon Nigiri \t\t";
            SALMON_NIGIRI = 41;
        }

        if (salmonRoll.isSelected()) {
            item3 = "Salmon Roll \t\t";
            SALMON_ROLL = 40;
        }
        if (caliMaki.isSelected()) {
            item4 = "California Maki \t\t";
            CALI_MAKI = 44;
        }
        if (tamago.isSelected()) {
            item5 = "Tamagoyaki \t\t\t";
            TAMAGOYAKI = 31;
        }
        if (mackNigiri.isSelected()) {
            item6 = "Mackerel Nigiri \t\t";
            MACK_NIGIRI = 38;
        }
        if (unagiNigiri.isSelected()) {
            item7 = "Unagi Nigiri \t\t";
            UNAGI_NIGIRI = 43;
        }
        if (shimeSaba.isSelected()) {
            item8 = "Shime Saba Nigiri \t";
            SHIME_SABA = 39;
        }
        if (takoNigiri.isSelected()) {
            item9 = "Tako Nigiri \t\t";
            TAKO_NIGIRI = 42;
        }
        if (ikuraNigiri.isSelected()) {
            item10 = "Ikura Nigiri \t\t";
            IKURA_NIGIRI = 41;
        }
        if (uniNigiri.isSelected()) {
            item11 = "Uni Nigiri \t\t\t";
            UNI_NIGIRI = 36;
        }
        if (tobikoNigiri.isSelected()) {
            item12 = "Tobiko Nigiri \t\t";
            TOBIKO_NIGIRI = 44;
        }
    }

    @FXML
    public void handleCheckoutAction(ActionEvent event) throws IOException {
        if (event.getSource() == checkoutBtn) {
            totalCost = TUNA_NIGIRI + SALMON_NIGIRI + SALMON_ROLL + CALI_MAKI
                    + TAMAGOYAKI + MACK_NIGIRI + UNAGI_NIGIRI + SHIME_SABA
                    + TAKO_NIGIRI + IKURA_NIGIRI + UNI_NIGIRI + TOBIKO_NIGIRI;

            //To print to text file use the code
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            String pattern = "$###,###.###";
            DecimalFormat df = new DecimalFormat(pattern);

            try (BufferedWriter bf = new BufferedWriter(new FileWriter("receipt.txt"))) {
                bf.write("*************** SUGOI SUSHI ****************");
                bf.newLine();
                bf.write(ft.format(date));
                bf.newLine();
                bf.newLine();

                if (item1 != null) {
                    bf.write(item1 + " SR." + TUNA_NIGIRI);
                    bf.newLine();
                }
                if (item2 != null) {
                    bf.write(item2 + " SR." + SALMON_NIGIRI);
                    bf.newLine();
                }

                if (item3 != null) {
                    bf.write(item3 + " SR." + SALMON_ROLL);
                    bf.newLine();
                }
                if (item4 != null) {
                    bf.write(item4 + " SR." + CALI_MAKI);
                    bf.newLine();
                }
                if (item5 != null) {
                    bf.write(item5 + " SR." + TAMAGOYAKI);
                    bf.newLine();
                }
                if (item6 != null) {
                    bf.write(item6 + " SR." + MACK_NIGIRI);
                    bf.newLine();
                }
                if (item7 != null) {
                    bf.write(item7 + " SR." + UNAGI_NIGIRI);
                    bf.newLine();
                }
                if (item8 != null) {
                    bf.write(item8 + " SR." + SHIME_SABA);
                    bf.newLine();
                }

                if (item9 != null) {
                    bf.write(item9 + " SR." + TAKO_NIGIRI);
                    bf.newLine();
                }
                if (item10 != null) {
                    bf.write(item10 + " SR." + IKURA_NIGIRI);
                    bf.newLine();
                }
                if (item11 != null) {
                    bf.write(item11 + " SR." + UNI_NIGIRI);
                    bf.newLine();
                }
                if (item12 != null) {
                    bf.write(item12 + " SR." + TOBIKO_NIGIRI);
                    bf.newLine();
                }
                bf.newLine();
                bf.write("Total Cost: SR." + totalCost);
                bf.newLine();
                bf.write("********* THANK YOU FOR YOUR ORDER *********");
            } catch (IOException ex) {
                Logger.getLogger(MenuDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("LastScene.fxml"));
            Object root = loader.load();
            LastController lastController = loader.getController();
            root = FXMLLoader.load(getClass().getResource("LastScene.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene((Parent) root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    public void displayName(String username, String contactNum) {
		nameLabel.setText("Hello, " + username);
                contact.setText("Contact: " + contactNum);
	}
}
