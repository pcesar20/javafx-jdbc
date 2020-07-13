package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	@FXML
	private MenuItem menuItemFuncionario;
	@FXML
	private MenuItem menuItemDepartament;
	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	public void onmenuItemFuncionarioAction() {
		System.out.println("Em desenvolvimento");
	}
	
	@FXML
	public void onmenuItemDepartamentoAction() {
		System.out.println("Em desenvolvimento");
	}
	
	@FXML
	public void onmenuItemSobreAction() {
		loadView("/gui/Sobre.fxml");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
	}
	
	private void loadView(String absoluteName)  {
		try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVBox = loader.load();
		Scene mainScene = Main.getMainScene();
		VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
		
		Node mainMenu = mainVbox.getChildren().get(0);
		mainVbox.getChildren().clear();
		mainVbox.getChildren().add(mainMenu);
		mainVbox.getChildren().addAll(newVBox.getChildren());
		
	} catch (IOException e) {
		Alerts.showAlert("Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
	}
		
	}

}
