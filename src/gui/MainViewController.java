package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
		System.out.println("Em desenvolvimento");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
	}

}
