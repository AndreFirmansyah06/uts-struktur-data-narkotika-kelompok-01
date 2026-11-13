package com.example.utsstrukdat.app;

import com.example.utsstrukdat.controller.PutusanController;
import com.example.utsstrukdat.model.KnowledgeRepository;
import com.example.utsstrukdat.model.Putusan;
import com.example.utsstrukdat.view.FXMLController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main {
    private static final KnowledgeRepository repository = new KnowledgeRepository();
    private static final PutusanController controller = new PutusanController(repository);
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/utsstrukdat/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        FXMLController fxController = fxmlLoader.getController();
        fxController.setController(controller);

        stage.setTitle("KMS Putusan Pengadilan Narkotika");
        stage.setScene(scene);
        stage.show();
    }
}
