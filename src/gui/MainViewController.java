package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import modelo.servicos.DepartamentoServico;

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
		loadView("/gui/ListaDepartamento.fxml", (ListaDepartamentoController controlador) -> {
			controlador.setDepartamentoServico(new DepartamentoServico());
			controlador.updateTableView();
		});
	}
	
	@FXML
	public void onmenuItemSobreAction() {
		loadView("/gui/Sobre.fxml", X -> {});
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
	}
	
	private synchronized <T> void loadView(String absoluteName, Consumer<T> iniAction)  {
		try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVBox = loader.load();
		Scene mainScene = Main.getMainScene();
		VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
		
		Node mainMenu = mainVbox.getChildren().get(0);
		mainVbox.getChildren().clear();
		mainVbox.getChildren().add(mainMenu);
		mainVbox.getChildren().addAll(newVBox.getChildren());
		
		T controller = loader.getController();
		iniAction.accept(controller);
		
	} catch (IOException e) {
		Alerts.showAlert("Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
	}
		
	}

}
