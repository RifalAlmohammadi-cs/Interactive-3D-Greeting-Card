
/***Computer Graphices Project
 * Done by: Rifal ALmohammadi , Deema Alhazmi  -- 
 */

package cgproject;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape3D;
import javafx.util.Duration;

public class CGproject extends Application{
    
    private static final int WIDTH = 900;
    private static final int HEIGHT = 650;

    @Override
    public void start(Stage primaryStage){
        
        
        //setup camera
        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);  // Set near clipping plane
        camera.setFarClip(1500); // Set far clipping plane
        camera.setTranslateZ(-750); // Move camera back
        camera.setTranslateY(-110); // Raise camera up
        camera.getTransforms().add(new Rotate(-15, Rotate.X_AXIS)); // Tilt camera for an overhead view
        
        Group party = new Group();
        Scene scene = new Scene(party, WIDTH, HEIGHT);
        scene.setCamera(camera);
        
        //background
        Image background = new Image("/projectImg/background.jpg");
        ImageView viewBG = new ImageView();
        viewBG.setImage(background);
        viewBG.setFitWidth(650);
        viewBG.setFitHeight(650);
        viewBG.setX(-310);
        viewBG.setY(-300);
        party.getChildren().add(viewBG);
        
   
        //Table 
        PhongMaterial tableMaterial = new PhongMaterial();
        tableMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/whitetexture.jpg")));
        
        Shape3D tableTop = new Cylinder(70, 10);
        tableTop.setMaterial(tableMaterial);
        tableTop.setTranslateY(180);
        Shape3D tableLeg = new Cylinder(10, 40, 5);
        tableLeg.setMaterial(tableMaterial);
        tableLeg.setTranslateY(70);
        tableLeg.setTranslateZ(-350);
        Shape3D tableBottom = new Cylinder(20, 7, 5);
        tableBottom.setMaterial(tableMaterial);
        tableBottom.setTranslateY(100);
        tableBottom.setTranslateZ(-335);
        Group table = new Group(tableBottom,tableLeg,tableTop);
        
        
        //Cake
        PhongMaterial firstCakeMaterial = new PhongMaterial();
        firstCakeMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/secondcakes.jpg")));
        PhongMaterial secondCakeMaterial = new PhongMaterial();
        secondCakeMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/secondcakes.jpg")));
        PhongMaterial thirdCakeMaterial = new PhongMaterial();
        thirdCakeMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/thirdcakes.jpg")));
        
        Shape3D firstCakelayer = new Cylinder(50, 20); 
        firstCakelayer.setMaterial(firstCakeMaterial); 
        firstCakelayer.setTranslateY(90); 
        firstCakelayer.setTranslateZ(-190);
        Shape3D secondCakelayer = new Cylinder(30, 20); 
        secondCakelayer.setMaterial(secondCakeMaterial); 
        secondCakelayer.setTranslateY(70); 
        secondCakelayer.setTranslateZ(-200);
        Shape3D thirdCakelayer = new Cylinder(15, 20); 
        thirdCakelayer.setMaterial(thirdCakeMaterial); 
        thirdCakelayer.setTranslateY(50); 
        thirdCakelayer.setTranslateZ(-200);
        
        Group cake = new Group(firstCakelayer, secondCakelayer, thirdCakelayer);
        
        
        //Carpet
        PhongMaterial carpetMaterial = new PhongMaterial();
        carpetMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/carpett.jpg")));
        Shape3D rug = new Box(300, 2, 250);
        rug.setMaterial(carpetMaterial);
        rug.setTranslateY(280);
        
        
        //Gifts
        PhongMaterial giftOneMaterial = new PhongMaterial();
        giftOneMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/gift1.jpg")));
        PhongMaterial giftTwoMaterial = new PhongMaterial();
        giftTwoMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/gift2.jpg")));
        PhongMaterial giftThreeMaterial = new PhongMaterial();
        giftThreeMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/projectImg/thirdgift.jpg")));
        
        Shape3D firstGift = new Box(40, 40, 40); // Create 3D shape - Box(width, height, depth)
        firstGift.setMaterial(giftOneMaterial); // Set 3D shape material
        firstGift.setTranslateX(100); // Move 3D shape to the right
        firstGift.setTranslateY(160);
        firstGift.setTranslateZ(-200);
        
        Shape3D secondGift = new Box(40, 40, 40); // Create 3D shape - Box(width, height, depth)
        secondGift.setMaterial(giftTwoMaterial); // Set 3D shape material
        secondGift.setTranslateX(160); // Move 3D shape to the right
        secondGift.setTranslateY(160); // Move 3D shape to the right
        secondGift.setTranslateZ(-200);

        Shape3D thirdGift = new Box(40, 40, 40); // Create 3D shape - Box(width, height, depth)
        thirdGift.setMaterial(giftThreeMaterial); // Set 3D shape material
        thirdGift.setTranslateX(140); // Move 3D shape to the right
        thirdGift.setTranslateY(140); // Move 3D shape to the right
        thirdGift.setTranslateZ(-160);
        
        Group boxes = new Group(firstGift, secondGift,thirdGift);
        
        //add all elements to the group
        party.getChildren().addAll(rug,table,cake,boxes);
        
        
        //adding balloons
        Image balloons = new Image("/projectImg/balloons.png");
        ImageView viewBalloons = new ImageView();
        viewBalloons.setImage(balloons);
        viewBalloons.setFitWidth(375);
        viewBalloons.setFitHeight(280);
        viewBalloons.setTranslateX(-250);
        viewBalloons.setTranslateY(-10);
        viewBalloons.setTranslateZ(-20);
        viewBalloons.setPreserveRatio(true);
        party.getChildren().add(viewBalloons);
        
        
        //adding candels
        Image candels = new Image("/projectImg/candels.png");
        ImageView viewcandels = new ImageView();
        viewcandels.setImage(candels);
        viewcandels.setFitHeight(30);
        viewcandels.setTranslateX(-10);
        viewcandels.setTranslateY(55);
        viewcandels.setTranslateZ(-35);
        viewcandels.setPreserveRatio(true);
        party.getChildren().add(viewcandels);
        
        
        //light shapes
        Sphere light1 = new Sphere(25);
        Sphere light2 = new Sphere(25);
        Sphere light3 = new Sphere(25);
        Cylinder wire1 = new Cylinder(2, 50);
        Cylinder wire2 = new Cylinder(2, 100);
        Cylinder wire3 = new Cylinder(2, 150);
        
        //light matirial
        PhongMaterial lightMaterial = new PhongMaterial();
        lightMaterial.setDiffuseColor(Color.valueOf("#efe4b0"));
        PhongMaterial wireMaterial = new PhongMaterial();
        wireMaterial.setDiffuseColor(Color.DARKGRAY);
        light1.setMaterial(lightMaterial);
        light2.setMaterial(lightMaterial);
        light3.setMaterial(lightMaterial);
        wire1.setMaterial(wireMaterial);
        wire2.setMaterial(wireMaterial);
        wire3.setMaterial(wireMaterial);
        
        
        //lights position
        light1.getTransforms().add(new Translate(-20, -40, 150));
        light2.getTransforms().add(new Translate(40, -5, 150));
        light3.getTransforms().add(new Translate(12, 40, 150));
        
        wire1.getTransforms().add(new Translate(-20, -90, 150));
        wire2.getTransforms().add(new Translate(40, -80, 150));
        wire3.getTransforms().add(new Translate(10, -60, 150));
        
        PointLight pointLight1 = new PointLight();
        pointLight1.getTransforms().add(new Translate(30, 600, -700));
        pointLight1.setLightOn(true);
        
        PointLight pointLight2 = new PointLight();
        pointLight2.getTransforms().add(new Translate(30, -50, -200));
        pointLight2.setLightOn(true);
        party.getChildren().addAll(pointLight1,pointLight2);
        
        Group lamp = new Group(wire3,light1,wire1,light2,wire2,light3);
        
        Image flags = new Image("/projectImg/partyFlag.png");
        ImageView viewFlags = new ImageView();
        viewFlags.setImage(flags);
        viewFlags.setFitWidth(650);
        viewFlags.setFitHeight(470);
        viewFlags.setX(-310);
        viewFlags.setY(-120);
                
        Rectangle dark = new Rectangle(WIDTH,HEIGHT);
        dark.setX(-310);
        dark.setY(-120);
        dark.setFill(Color.BLACK);
        dark.setOpacity(0.7);
        dark.setVisible(false);
        
        party.getChildren().addAll(lamp,viewFlags,dark);
        
        
        //congrats & firework
        Image congrats = new Image("/projectImg/congrats.png");
        ImageView imageV1 = new ImageView();
        imageV1.setImage(congrats);
        imageV1.setFitWidth(375);
        imageV1.setFitHeight(150);
        imageV1.setTranslateZ(-50);
        imageV1.setPreserveRatio(true);
        
        Image fireworks = new Image("/projectImg/fireworks.gif");
        ImageView imageV2 = new ImageView();
        imageV2.setImage(fireworks);
        imageV2.setFitWidth(275);
        imageV2.setTranslateX(50);
        imageV2.setTranslateY(50);
        imageV2.setPreserveRatio(true);  
        Group con = new Group(imageV1,imageV2);
        
        SubScene subScene = new SubScene(con, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);
        subScene.setTranslateX(-190);
        subScene.setVisible(false);        //to hide the sub scene until the mouse is clicked
        party.getChildren().add(subScene);
        
        //add fade-Out transitions to make "congrats" word and the firework fade in and out after the mouse is clicked
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(5), subScene);
        fadeOut.setFromValue(1.0); // Start from fully opaque
        fadeOut.setToValue(0.0); // Fade out to fully transparent
      

      //Mouse clicked event
      scene.setOnMouseClicked(event -> {
             subScene.setVisible(true);
             fadeOut.play();
        });
      
      //light on/off event
        scene.setOnKeyPressed(event -> {
            if(event.getCode()== KeyCode.O){
                pointLight1.setLightOn(true);  //turn light on
                pointLight2.setLightOn(true);
                dark.setVisible(false);
            } else if(event.getCode()== KeyCode.F){
                pointLight1.setLightOn(false);  //turn light off
                pointLight2.setLightOn(false);
                dark.setVisible(true);
            }
        }); 
        
        primaryStage.setTitle("Party Scene!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
       
    }
    

    public static void main(String[] args) {
        launch(args);
    }

}
