package ru.nsc.bionet.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.nsc.bionet.model.Person;
import ru.nsc.bionet.view.PersonOverviewController;

public class MainAPP extends Application {

	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private Parent RootLayout;

	/*
	 * ���������� ������� ����� 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		
		initRootLayout();
		showPersonOverview();
	}
/*
 * ���������� � �������� ������ �������� �� ���������
 */
private void showPersonOverview() {
	try {
		//��������� �������� �� ���������
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainAPP.class.getResource("view/PersonOverview.fxml"));
		AnchorPane personOverview = (AnchorPane) loader.load();
		
		//�������� �������� �� ��������� � ����� ��������� ������
		rootLayout.setCenter(personOverview);
	} catch (IOException e) {
		e.printStackTrace();		
		}
	}
/*
 * �������������� �������� �����
 */
	private void initRootLayout() {
		try {
			// ��������� �������� ����� �� fxml �����
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//���������� �����, ���������� �������� �����
			Scene scene = new Scene(RootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
		}
	}
	// ������, � ���� ������������ ������ ���������.
	 private ObservableList<Person> personData =   FXCollections.observableArrayList();
	// �����������
	private ObservableList<Person> Person;
	    public MainAPP() {
	        // � �������� ������� ��������� ��������� ������
	        personData.add(new Person("������", "�����"));
	        personData.add(new Person("�����", "��������"));
		 // ...
	    }
	    
	    /**
	     * ���������� ������ � ���� ������������ ������ ���������.
	     * @return
	     */
	    public ObservableList<Person> getPersonData() {
	        return Person;
	    }
	    public void showPersonOverview() {
	        try {
	            // ��������� �������� �� ���������.
	            FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(MainAPP.class.getResource("view/PersonOverview.fxml"));
	            AnchorPane personOverview = (AnchorPane) loader.load();

	            // �������� �������� �� ��������� � ����� ��������� ������.
	            rootLayout.setCenter(personOverview);
	                
	           // ��� ����������� ������ � �������� ����������.
	           PersonOverviewController controller = loader.getController();
	           controller.setMainApp(this);
	           } catch (IOException e) {
	                e.printStackTrace();
	           }
	        }

	
	public static void main(String[] args) {
		launch(args);
	}
}
