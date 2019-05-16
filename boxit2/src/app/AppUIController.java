package app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AppUIController implements Initializable {

    @FXML
    private AnchorPane main_anchor;
    private Button spotlight_btn;
    private Button lab_btn;
    private Button subs_btn;
    private Button hist_btn;
    private ImageView next_img;
    private ImageView prev_img;
    private Pane spotlight_pane;
    private Pane lab_pane;
    private Pane subs_pane;
    private Pane hist_pane;
    private ImageView spot_img1;
    private ImageView spot_img2;
    private ImageView spot_img3;
    private ImageView spot_img4;
    private ChoiceBox mold_cbox;
    private Button random_btn;
    private Text unitpriceoutput_txt;
    private TextField quantityinput_txtf;
    private Text subtotaloutput_txt;
    private TextField ceilinginput_txtf;
    private ImageView prevpalette_img;
    private ImageView nextpalette_img;
    private ImageView palette_img1;
    private ImageView palette_img2;
    private ImageView palette_img3;
    private ImageView prevcategories_img;
    private ImageView nextcategories_img;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private Button boxit_btn;
    private ImageView prevalt_img;
    private ImageView nextalt_img;
    private ImageView alt_img1;
    private ImageView alt_img2;
    private ImageView alt_img3;
    private Text alt_txt1;
    private Text alt_txt2;
    private Text alt_txt3;
    private Text altprice_txt1;
    private Text altprice_txt2;
    private Text altprice_txt3;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
