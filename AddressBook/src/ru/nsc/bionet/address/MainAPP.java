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
import ru.nsc.bionet.address.model.Person;
import ru.nsc.bionet.address.view.PersonOverviewController;

public class MainAPP extends Application {

	
	private Stage primaryStage;
	private BorderPane rootLayout;
	//private Parent RootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		
		initRootLayout();
		showPersonOverview();
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
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
		}
	}	

	
/*
 * ���������� � �������� ������ �������� �� ���������
 */
public void showPersonOverview() {
    try {
        // ��������� �������� �� ���������.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainAPP.class.getResource("view/PersonOverview.fxml"));
        AnchorPane personOverview = (AnchorPane) loader.load();

        // �������� �������� �� ��������� � ����� ��������� ������.
        rootLayout.setCenter(personOverview); //��� ����� ������ ������
            
       // ��� ����������� ������ � �������� ����������.
       PersonOverviewController controller = loader.getController();
       controller.setMainApp(this);
       } catch (IOException e) {
            e.printStackTrace();
       }
    }


/*
 * ���������� ������� ����� 
 * @return
 */
public Stage getPrimaryStage() {
	return primaryStage;
}

//��� ������ ������ ���������

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


	
	public static void main(String[] args) {
		launch(args);
	}
}
