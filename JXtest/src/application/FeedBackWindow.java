package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.*;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import java.util.HashMap;


public class FeedBackWindow extends Application {
  private ImageView imageview;
  private Font serif;
  private Text text2;
  private Text text3;
  private Button contButton;


  public static void main(String[] args) {
      launch(args);
  }

  public void GiveFeedBack(){
    HashMap<Integer, Integer> testAnswers = new HashMap<Integer, Integer>();//this hasmap has the questions
    //and correct answers for this quize
    //preloading questions and correct answers
    //these are the quiz questions and their correct answers
		testAnswers.put(1, 3);

		// create new feedback object at beginning of each quiz attempt, feeding in
		//all questions and correct answers
		Feedback feedback = new Feedback(testAnswers);
		//for each question when the student answers do this
		feedback.newAnswer(1, 3); // student submits answer

		// get immediate feedback for answer
		ArrayList<Object> thisFeedback = feedback.getFeedback(1, 3);
		boolean correct = (boolean) thisFeedback.get(0);
		Integer score = (Integer) thisFeedback.get(1);
		Integer answered = (Integer) thisFeedback.get(2);

		System.out.println(score);
		System.out.println(answered);
    String img;
    String txt;

    if (correct == true){
      img = "congrats.gif";
      txt = "CONGRATULATIONS, YOU'VE GOT IT!!";
    } else {
      img = "sorry.jpg";
      txt = "OH NO!, WRONG ANSWER SORRY!";
    }
    Image image = new Image(img);

    imageview = new ImageView();
    imageview.setImage(image);
    imageview.setFitWidth(450);
    imageview.setPreserveRatio(true);
    imageview.setSmooth(true);
    imageview.setCache(true);

    text2 = new Text(txt);
    serif = Font.font("Serif", 30);
    text2.setFont(serif);
    text2.setFill(Color.ORANGE);

    text3 = new Text("Your Score is  " + score + "/" + answered);
    text3.setFont(serif);
    text3.setFill(Color.GREEN);
    contButton = new Button("CONTINUE");

  }

  // Override the start() method.
  public void start(Stage myStage) {
    myStage.setTitle("Feedback Window");
    BorderPane rootNode = new BorderPane( );
    Scene myScene = new Scene(rootNode, 800, 600);
    myStage.setScene(myScene);
    // Create controls and put them into the five BorderPane locations.

    // Center
    //header text
    Text text1 = new Text("FEED BACK");
    serif = Font.font("Serif", 30);
    text1.setFont(serif);
    text1.setFill(Color.BLUE);
 /*
    this.GiveFeedBack();
    VBox fbkBox = new VBox(10);
    fbkBox.getChildren().addAll(text1, imageview, text2, text3, contButton);
    fbkBox.setAlignment(Pos.TOP_CENTER);
    rootNode.setCenter(fbkBox);
    BorderPane.setAlignment(fbkBox, Pos.TOP_CENTER);
    BorderPane.setMargin(fbkBox, new Insets(10, 10, 10, 10));
    
*/
    // Show the stage and its scene.
    myStage.show();
 }
}
