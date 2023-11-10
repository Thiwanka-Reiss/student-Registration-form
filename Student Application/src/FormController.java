import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    public JFXTextField nameTextField;
    public JFXTextField ageTextFeild;
    public JFXTextField contactTextField;
    public JFXTextField emailTextField;
    public JFXRadioButton femaleRadioBtn;
    public ToggleGroup gender;
    public JFXRadioButton maleRadioBtn;
    public Label genderLabel;
    public JFXButton submitButton;
    public ImageView backgroundImage;
    public Pane sidePane;
    public Label mainTopicLabel;
    public Label ageValidationText;
    public Label contactValidationText;
    public Label emailValidationText;
    public Label nameValidationText;
    public Label genderValidationText;
    public Label testLabel;

    private String genderSelected=null;

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
            case 7:femaleRadioBtn.setVisible(true);
                submitButton.setVisible(true);break;
        }
    }

    public void typingAnimation(Label label, String str,int i){
        final int[] j = {0};
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.08),
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
                Duration.seconds(0.08),
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextField[] textFields={nameTextField,contactTextField,emailTextField,ageTextFeild};
        makeInvisibleAndFocusAble(textFields);
        femaleRadioBtn.setVisible(false);
        maleRadioBtn.setVisible(false);
        genderLabel.setVisible(false);
        submitButton.setVisible(false);
        makeTextFieldsVisisble(0);

        femaleRadioBtn.setFocusTraversable(false);
        maleRadioBtn.setFocusTraversable(false);
        submitButton.setFocusTraversable(false);

        RequiredFieldValidator validator=new RequiredFieldValidator();
        nameTextField.getValidators().add(validator);

        nameTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
           @Override
           public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
               if(!t1){
                   nameFocusLost();
               }else{
                   nameFocusGained();
               }
           }
        });

        RequiredFieldValidator validator1=new RequiredFieldValidator();
        ageTextFeild.getValidators().add(validator1);

        ageTextFeild.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(!t1){
                    ageFocusLost();
                }else{
                    ageFocusGained();
                }
            }
        });

        RequiredFieldValidator validator2=new RequiredFieldValidator();
        contactTextField.getValidators().add(validator2);

        contactTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(!t1){
                    contactFocusLost();
                }else{
                    contactFocusGained();
                }
            }
        });

        RequiredFieldValidator validator3=new RequiredFieldValidator();
        emailTextField.getValidators().add(validator2);

        emailTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(!t1){
                    emailFocusLost();
                }else{
                    emailFocusGained();
                }
            }
        });
    }

    private void nameFocusLost(){
        isValidName();
    }

    private void nameFocusGained(){
        nameValidationText.setText("");
    }

    private void emailFocusGained(){ emailValidationText.setText("");}

    private void emailFocusLost(){
        isVaildEmail();
    }

    private void contactFocusGained(){
        contactValidationText.setText("");
    }

    private void contactFocusLost(){
        isValidContact();
    }

    private void ageFocusGained(){
       ageValidationText.setText("");
    }

    private void ageFocusLost(){
        isValidAge();
    }

    private void makeInvisibleAndFocusAble(TextField[] c){
        for (TextField a:c) {
            a.setVisible(false);
            a.setFocusTraversable(false);
        }
    }

    public void ageKeyReleased(KeyEvent keyEvent) {
        isValidAge();
    }


    public void contactKeyReleased(KeyEvent keyEvent) {
        String contact=contactTextField.getText().trim();
        if(isNumber(contact)||contact.equals("0")){
            contactValidationText.setText("");
        }else{
            contactValidationText.setText("Invalid Contact Number");
        }
    }

    private boolean isNumber(String string){
        if(string.equals(null)|| string.equals("")){
            return false;
        }

        for (int i = 0; i < string.length(); i++){
            if(!(string.charAt(i)=='0'||string.charAt(i)=='1'||string.charAt(i)=='2'
                    ||string.charAt(i)=='3'||string.charAt(i)=='4'||string.charAt(i)=='5'
                    ||string.charAt(i)=='6'||string.charAt(i)=='7'||string.charAt(i)=='8'||string.charAt(i)=='9')){
                return false;
            }
        }
        if(string.length()<=10){
            if(Integer.parseInt(string)==0){
                return false;
            }
        }
        return true;
    }

    private boolean isValidName(){
        String name=nameTextField.getText().trim();
        if(name.equals(null)||name.equals("")){
            nameValidationText.setText("No Name Given");
            return false;
        }else {
            nameValidationText.setText("");
            return true;
        }
    }

    private boolean isValidAge(){
        String age=ageTextFeild.getText().trim();
        if(age.equals(null)||age.equals("")){
            ageValidationText.setText("No Age Entered");
            return false;
        }else if(isNumber(age)){
            ageValidationText.setText("");
            return true;
        }else{
            ageValidationText.setText("Invalid Age");
            return false;
        }
    }
    private boolean isValidContact(){
        String contact=contactTextField.getText().trim();
        if(contact.equals(null)||contact.equals("")){
            contactValidationText.setText("No Contact Entered");
            return false;
        }else if(isNumber(contact)){
            if(contact.length()==10){
                if(Integer.parseInt(contact)/1000000000==0){
                    contactValidationText.setText("");
                    return true;
                }
            }
            contactValidationText.setText("InvalidContact Number");
            return false;

        }
        contactValidationText.setText("Invalid Contact Number");
        return false;
    }

    private boolean isVaildEmail(){
        String email=emailTextField.getText().trim();
        if(email.equals(null)||email.equals("")){
            emailValidationText.setText("No Email Given");
            return false;
        }else if(email.substring(email.length()-10,email.length()).equals("@gmail.com")){
            emailValidationText.setText("");
            return true;
        }else {
            emailValidationText.setText("Invalid Email");
            return false;
        }
    }

    private boolean isValidGender(){
        if(genderSelected!=null){
            return true;
        }
        genderValidationText.setText("Select Gender");
        return false;
    }

    @FXML
    private void getGender(ActionEvent actionEvent) {
        if(maleRadioBtn.isSelected()){
            genderSelected=maleRadioBtn.getText();
        }else if(femaleRadioBtn.isSelected()){
            genderSelected=femaleRadioBtn.getText();
        }
    }

    private boolean allConditionsSatisfied(){
        if(isValidName()|isValidAge()|isValidContact()|isVaildEmail()|isValidGender()){
            return true;
        }
        return false;
    }

    public void submitBtnClicked(MouseEvent mouseEvent) {
        String name=nameTextField.getText().trim();
        String age=ageTextFeild.getText().trim();
        String contact=contactTextField.getText().trim();
        String emailAddress=emailTextField.getText().trim();
        if(allConditionsSatisfied()){
            StudentList customerList = DBConnection.getInstance().getStudentList();
            customerList.add( name, age, contact, emailAddress,genderSelected);
        }
    }
}
