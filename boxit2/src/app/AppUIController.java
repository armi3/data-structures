package app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    Item[] currentalts;
    int counter =0;

    @FXML
    private AnchorPane main_anchor, mold1, mold2, mold3;
    @FXML
    private Button spotlight_btn, lab_btn, subs_btn, hist_btn, random_btn, boxit_btn;
    @FXML
    private ImageView next_img, prev_img;
    @FXML
    private Pane spotlight_pane, lab_pane, subs_pane, hist_pane, current;
    @FXML
    private ImageView spot_img1, spot_img2, spot_img3, spot_img4, prevpalette_img, nextpalette_img, palette_img1, palette_img2;
    @FXML
    private ImageView palette_img3, prevcategories_img, nextcategories_img, prevalt_img, nextalt_img, alt_img1, alt_img2, alt_img3;
    @FXML
    private ImageView a1, b1, c1, d1, a2, b2, c2, d2, e2, a3, b3, c3, d3, e3;
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

    @FXML
    public void preview(Object newValue){
        double unitprice = 0;
        if(newValue.equals(mp.getMolds()[1].getName())){ //beauty
            mold1.setVisible(true);
            mold2.setVisible(false);
            mold3.setVisible(false);
            a1.setImage(mp.getMolds()[1].getItems()[0].getImage());
            b1.setImage(mp.getMolds()[1].getItems()[1].getImage());
            c1.setImage(mp.getMolds()[1].getItems()[2].getImage());
            d1.setImage(mp.getMolds()[1].getItems()[3].getImage());

            for(Item a: mp.getMolds()[1].getItems()){
                unitprice=unitprice+a.getPrice();
            }
            unitpriceoutput_txt.setText(Double.toString(unitprice));

        } else if(newValue.equals(mp.getMolds()[0].getName())){ //emf
            mold1.setVisible(false);
            mold2.setVisible(true);
            mold3.setVisible(false);
            a2.setImage(mp.getMolds()[0].getItems()[0].getImage());
            b2.setImage(mp.getMolds()[0].getItems()[1].getImage());
            c2.setImage(mp.getMolds()[0].getItems()[2].getImage());
            d2.setImage(mp.getMolds()[0].getItems()[3].getImage());
            e2.setImage(mp.getMolds()[0].getItems()[4].getImage());

            for(Item a: mp.getMolds()[0].getItems()){
                unitprice=unitprice+a.getPrice();
            }
            unitpriceoutput_txt.setText(Double.toString(unitprice));

        } else if(newValue.equals(mp.getMolds()[2].getName())){ //zodiac
            mold1.setVisible(false);
            mold2.setVisible(false);
            mold3.setVisible(true);
            a3.setImage(mp.getMolds()[2].getItems()[0].getImage());
            b3.setImage(mp.getMolds()[2].getItems()[1].getImage());
            c3.setImage(mp.getMolds()[2].getItems()[2].getImage());
            d3.setImage(mp.getMolds()[2].getItems()[3].getImage());
            e3.setImage(mp.getMolds()[2].getItems()[4].getImage());

            for(Item a: mp.getMolds()[2].getItems()){
                unitprice=unitprice+a.getPrice();
            }
            unitpriceoutput_txt.setText(Double.toString(unitprice));

        }

    }

    @FXML
    public void editItem(MouseEvent event){
        if (event.getTarget()== a1){
            currentalts = mp.getMolds()[1].getAlts()[0];
            counter=0;
            showAlts(currentalts, counter);
//            int i =0;
//            while (i!=mp.getMolds()[1].getAlts().length){
//
//                i++;
//            }

        } else if (event.getTarget()== b1){
            currentalts = mp.getMolds()[1].getAlts()[1];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== c1){
            currentalts = mp.getMolds()[1].getAlts()[2];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== d1){
            currentalts = mp.getMolds()[1].getAlts()[0];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== a2){
            currentalts = mp.getMolds()[0].getAlts()[0];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== b2){
            currentalts = mp.getMolds()[0].getAlts()[1];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== c2){
            currentalts = mp.getMolds()[0].getAlts()[2];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== d2){
            currentalts = mp.getMolds()[0].getAlts()[3];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== e2){
            currentalts = mp.getMolds()[0].getAlts()[4];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== a3){
            currentalts = mp.getMolds()[2].getAlts()[0];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== b3){
            currentalts = mp.getMolds()[2].getAlts()[1];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== c3){
            currentalts = mp.getMolds()[2].getAlts()[2];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== d3){
            currentalts = mp.getMolds()[2].getAlts()[3];
            counter=0;
            showAlts(currentalts, counter);

        } else if (event.getTarget()== e3){
            currentalts = mp.getMolds()[2].getAlts()[4];
            counter=0;
            showAlts(currentalts, counter);

        }

    }

    @FXML
    private void showAlts(Item[] currentalts, int counter) {
        alt_img1.setVisible(false);
        alt_img2.setVisible(false);
        alt_img3.setVisible(false);
        altprice_txt1.setVisible(false);
        altprice_txt2.setVisible(false);
        altprice_txt3.setVisible(false);
        prevalt_img.setVisible(false);
        nextalt_img.setVisible(false);
        if(currentalts[counter]!=null){
            alt_img1.setImage(currentalts[counter].getAlt_image());
            alt_img1.setVisible(true);
            altprice_txt1.setText(Double.toString(currentalts[counter].getPrice()));
            altprice_txt1.setVisible(true);
        }
        if(currentalts[counter+1]!=null){
            alt_img2.setImage(currentalts[counter+1].getAlt_image());
            alt_img2.setVisible(true);
            altprice_txt2.setText(Double.toString(currentalts[counter+1].getPrice()));
            altprice_txt2.setVisible(true);
        }
        if(currentalts[counter+2]!=null){
            alt_img3.setImage(currentalts[counter+2].getAlt_image());
            alt_img3.setVisible(true);
            altprice_txt3.setText(Double.toString(currentalts[counter+2].getPrice()));
            altprice_txt3.setVisible(true);
        }
        if(currentalts[counter-1]!=null){
            prevalt_img.setVisible(true);
        }
        if(currentalts[counter+3]!=null){
            nextalt_img.setVisible(true);
        }

    }

    @FXML
    private void handleFlowAlts(MouseEvent event){
        if(event.getTarget()==prevalt_img){
            counter--;
            showAlts(currentalts, counter);
        } else if(event.getTarget()==nextalt_img){
            counter++;
            showAlts(currentalts, counter);
        }

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

        mold_cbox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> preview(newValue));

    }


}
