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
	 * Возвращает главную сцену 
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
 * показывает в корневом макете сведения об адресадах
 */
private void showPersonOverview() {
	try {
		//загружаем сведения об адресатах
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainAPP.class.getResource("view/PersonOverview.fxml"));
		AnchorPane personOverview = (AnchorPane) loader.load();
		
		//Помещаем сведения об адресатах в центр корневого макета
		rootLayout.setCenter(personOverview);
	} catch (IOException e) {
		e.printStackTrace();		
		}
	}
/*
 * Инициализирует корневой макет
 */
	private void initRootLayout() {
		try {
			// загружаем корневой макет из fxml файла
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//отображаем сцену, содержащую корневой макет
			Scene scene = new Scene(RootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
		}
	}
	// Данные, в виде наблюдаемого списка адресатов.
	 private ObservableList<Person> personData =   FXCollections.observableArrayList();
	// Конструктор
	private ObservableList<Person> Person;
	    public MainAPP() {
	        // В качестве образца добавляем некоторые данные
	        personData.add(new Person("Сергей", "Лашин"));
	        personData.add(new Person("Захар", "Мустафин"));
		 // ...
	    }
	    
	    /**
	     * Возвращает данные в виде наблюдаемого списка адресатов.
	     * @return
	     */
	    public ObservableList<Person> getPersonData() {
	        return Person;
	    }
	    public void showPersonOverview() {
	        try {
	            // Загружаем сведения об адресатах.
	            FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(MainAPP.class.getResource("view/PersonOverview.fxml"));
	            AnchorPane personOverview = (AnchorPane) loader.load();

	            // Помещаем сведения об адресатах в центр корневого макета.
	            rootLayout.setCenter(personOverview);
	                
	           // Даём контроллеру доступ к главному приложению.
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
