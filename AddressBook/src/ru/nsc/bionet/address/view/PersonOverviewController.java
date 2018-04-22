package ru.nsc.bionet.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.nsc.bionet.address.MainAPP;
import ru.nsc.bionet.address.model.Person;

public class PersonOverviewController {
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;

	// ������ �� ������� ����������.
	private MainAPP mainApp;
	
	/**
	 * ������������� ������-�����������. ���� ����� ���������� �������������
	 * ����� ����, ��� fxml-���� ����� ��������.
	 */
	@FXML
	private void initialize() {
	// ������������� ������� ��������� � ����� ���������.
	firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
	lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
	}
	/**
	 * ���������� ������� �����������, ������� ��� �� ���� ������.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainAPP mainApp) {
	this.mainApp = mainApp;

	// ���������� � ������� ������ �� ������������ ������
	personTable.setItems(mainApp.getPersonData());
	}


}
