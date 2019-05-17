package app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AppUIController implements Initializable {
    Marketplace mp = new Marketplace();

    @FXML
    private AnchorPane main_anchor;
    @FXML
    private Button spotlight_btn, lab_btn, subs_btn, hist_btn, random_btn, boxit_btn;
    @FXML
    private ImageView next_img, prev_img;
    @FXML
    private Pane spotlight_pane, lab_pane, subs_pane, hist_pane, current;
    @FXML
    private ImageView spot_img1, spot_img2, spot_img3, spot_img4, prevpalette_img, nextpalette_img, palette_img1, palette_img2;
    @FXML
    private ImageView palette_img3, prevcategories_img, nextcategories_imgprevalt_img, nextalt_img, alt_img1, alt_img2, alt_img3;
    @FXML
    private ChoiceBox mold_cbox;
    @FXML
    private Text unitpriceoutput_txt, subtotaloutput_txt, alt_txt1, alt_txt2, alt_txt3, altprice_txt1, altprice_txt2, altprice_txt3;
    @FXML
    private CheckBox cb1, cb2, cb3, cb4, cb5;
    @FXML
    private TextField quantityinput_txtf, ceilinginput_txtf;

    @FXML
    private void handleFlowAction(MouseEvent event){
        if (event.getTarget()== prev_img && lab_pane.isVisible()){
            //current = spotlight_pane;
            lab_pane.setVisible(false);
            spotlight_pane.setVisible(true);
        } else if (event.getTarget()== prev_img && subs_pane.isVisible()){
            //current = lab_pane;
            subs_pane.setVisible(false);
            lab_pane.setVisible(true);
        } else if (event.getTarget()== next_img && spotlight_pane.isVisible()){
            //current = lab_pane;
            spotlight_pane.setVisible(false);
            lab_pane.setVisible(true);
        } else if (event.getTarget()== next_img && lab_pane.isVisible()){
            //current = lab_pane;
            lab_pane.setVisible(false);
            subs_pane.setVisible(true);
        } else if (event.getTarget()== spotlight_btn){
            //current = lab_pane;
            spotlight_pane.setVisible(true);
            lab_pane.setVisible(false);
            subs_pane.setVisible(false);
        } else if (event.getTarget()== lab_btn){
            //current = lab_pane;
            spotlight_pane.setVisible(false);
            lab_pane.setVisible(true);
            subs_pane.setVisible(false);
        } else if (event.getTarget()== subs_btn){
            //current = lab_pane;
            spotlight_pane.setVisible(false);
            lab_pane.setVisible(false);
            subs_pane.setVisible(true);
        }
        //mold_cbox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.print("---"+newValue));


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mp.uploadInventory();
        mp.updateInventory();
        mp.buildMolds();
        System.out.print("---"+mp.getMolds()[0].getItems()[0].getName());
        for(Box a: mp.getMolds()){
            mold_cbox.getItems().add(a.getName());
        }

    }
}
