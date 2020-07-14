package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import modelo.servicos.DepartamentoServico;

public class ListaDepartamentoController implements Initializable{
	
	private DepartamentoServico servico;
			
	@FXML
	private TableView<Department> tvDepartamento;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	public  void onbtNewAction(ActionEvent event) {
		Stage parteSt = Utils.currentStage(event);
//		Alerts.showAlert("Aviso", null, "Ainda em desenvolvimento!", AlertType.INFORMATION);
		createDialogForm("/gui/DepartmentForm.fxml", parteSt);
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
		List<Department> list = servico.findAll();
		obsList = FXCollections.observableArrayList(list);
		tvDepartamento.setItems(obsList);
	}
	
	private void createDialogForm(String absoluteName, Stage parentStage) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		Pane pane = loader.load();
		Stage dialogSt = new Stage();
		dialogSt.setTitle("Entre com os dados do departamento");
		dialogSt.setScene(new Scene(pane));
		dialogSt.setResizable(false);
		dialogSt.initOwner(parentStage);
		dialogSt.initModality(Modality.WINDOW_MODAL);
		dialogSt.showAndWait();
		} catch(IOException e) {
			Alerts.showAlert("Exceção", "Erro ao carregar view", e.getMessage(), AlertType.ERROR);
		}
		
	}

}
