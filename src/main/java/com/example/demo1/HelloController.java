package com.example.demo1;

import com.example.presentation.DotController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{
    @FXML
    private AnchorPane mainPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Circle circle = new Circle();
        circle.setRadius(10);
        mainPane.getChildren().add(circle);
        var controller = new DotController(5, 800, 600);
        for(int i = 0; i <= controller.getDots().length - 1; i++) {
            Circle dotsCircle = new Circle();
            dotsCircle.setRadius(10);
            dotsCircle.setCenterX(controller.getDots()[i].getP().x());
            dotsCircle.setCenterY(controller.getDots()[i].getP().y());
            mainPane.getChildren().add(dotsCircle);
        }
        controller.addOnMainDotPositionListener((observableValue, coords, t1) -> {
            Platform.runLater(
                    () -> {
                        circle.setCenterX(t1.x());
                        circle.setCenterY(t1.y());
                    }
            );
        });
    }
}