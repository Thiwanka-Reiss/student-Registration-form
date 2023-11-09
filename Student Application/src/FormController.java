import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FormController {

    public JFXTextField nameTextField;
    public JFXTextField ageTextFeild;
    public JFXTextField contactTextField;
    public JFXTextField emailTextField;
    public JFXRadioButton femaleRadioBtn;
    public ToggleGroup gender;
    public JFXRadioButton maleRadioBtn;
    public Label genderLabel;
    private boolean mouseEnterdOnce=true;

    public ImageView backgroundImage;

    public Pane sidePane;
    public Label mainTopicLabel;

    public void sidePaneFocused(MouseEvent mouseEvent) {

        sidePane. setStyle("-fx-border-color: \t\n" +
                "#ffff00  ;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-color: black;" +
                "-fx-background-radius: 25px;" +
                "-fx-border-width:5px");

    }

    public void sidePaneFocusLost(MouseEvent mouseEvent) {
        sidePane. setStyle("-fx-border-color: blue;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-color: black;" +
                "-fx-background-radius: 25px;" +
                "-fx-border-width:5px");
    }
    private final String str ="Student Registration Form.";
    public void mouseEnteredFrame(MouseEvent mouseEvent) {
        if(mouseEnterdOnce){
            ageTextFeild.setVisible(false);
            nameTextField.setVisible(false);
            contactTextField.setVisible(false);
            emailTextField.setVisible(false);
            femaleRadioBtn.setVisible(false);
            maleRadioBtn.setVisible(false);
            genderLabel.setVisible(false);
            makeTextFieldsVisisble(0);
            mouseEnterdOnce=false;
        }
    }

    public void makeTextFieldsVisisble(int j){
        switch(j){
            case 0:mainTopicLabel.setVisible(true);
                typingAnimation(mainTopicLabel, "Student Registration Form.",j);
                break;
            case 1:
                mainTopicLabel.setUnderline(true);
                nameTextField.setVisible(true);
                typingAnimationPrompt(nameTextField, "Enter Name",j);break;
            case 2:ageTextFeild.setVisible(true);
                typingAnimationPrompt(ageTextFeild, "Enter Age",j);break;
            case 3:contactTextField.setVisible(true);
                typingAnimationPrompt(contactTextField, "Enter Contact Number",j);break;
            case 4:emailTextField.setVisible(true);
                typingAnimationPrompt(emailTextField, "Enter Email Address",j);break;
            case 5:genderLabel.setVisible(true);
                typingAnimation(genderLabel, "Gender",j);break;
            case 6:maleRadioBtn.setVisible(true);
            case 7:femaleRadioBtn.setVisible(true);break;
        }
    }

    public void typingAnimation(Label label, String str,int i){
        final int[] j = {0};
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.1),
                event -> {
                    if (j[0] > str.length()) {
                        timeline.stop();
                        makeTextFieldsVisisble(1+i);
                    }else {
                        label.setText(str.substring(0, j[0]));
                        j[0] += 1;
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void typingAnimationPrompt(TextField label, String str,int i){
        final int[] j = {0};
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.1),
                event -> {
                    if (j[0] > str.length()) {
                        timeline.stop();
                        makeTextFieldsVisisble(1+i);
                    }else {
                        label.setPromptText(str.substring(0, j[0]));
                        j[0] += 1;
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
