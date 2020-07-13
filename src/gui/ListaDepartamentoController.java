package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.entidades.Departamento;
import modelo.servicos.DepartamentoServico;

public class ListaDepartamentoController implements Initializable{
	
	private DepartamentoServico servico;
			
	@FXML
	private TableView<Departamento> tvDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Departamento, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Departamento> obsList;
	
	public  void onbtNewAction() {
		Alerts.showAlert("Aviso", null, "Ainda em desenvolvimento!", AlertType.INFORMATION);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}
	
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvDepartamento.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void setDepartamentoServico(DepartamentoServico servico) {
		this.servico = servico;
	}
	
	public void updateTableView() {
		if (servico == null) {
			throw new IllegalStateException("Serviço está nulo");
		}
		List<Departamento> list = servico.findAll();
		obsList = FXCollections.observableArrayList(list);
		tvDepartamento.setItems(obsList);
	}

}
