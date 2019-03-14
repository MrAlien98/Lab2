package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import exceptions.NoBookException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Book;
import model.Bookshelf;
import model.Client;
import model.Library;

/**
 * Main project class
 * 
 */
public class Main extends Application {

	static Library lib;
	
	public Main() {
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initializeModel(int x) {
		String route="";
		boolean flag=false;
		if(x>0) {
			route="src/test cases/BasicInput.txt";
			flag=false;
		}else {
			route="src/test cases/RandomInput.txt";
			flag=true;
		}
		try {
			File input=new File(route);
			BufferedReader br=new BufferedReader(new FileReader(input));
			int cases=Integer.parseInt(br.readLine());
			while(cases>0) {
				int cashiers=Integer.parseInt(br.readLine());
				int bookshelfs=Integer.parseInt(br.readLine());
				lib=new Library(cashiers, bookshelfs);
				int c=0;
				while(bookshelfs>0) {
					String bsh=br.readLine();
					String[] idnbs=bsh.split(" ");
					String idBF=idnbs[0];
					int bookNumber=Integer.parseInt(idnbs[1]);
					lib.getBookshelfs()[c]=new Bookshelf(idBF, bookNumber);
					while(bookNumber>0) {
						String book=br.readLine();
						String[] eachBook=book.split(" ");
						lib.getBookshelfs()[Integer.parseInt(idnbs[0])-1].getBookHash().add(eachBook[0], new Book(Integer.parseInt(idnbs[0]), eachBook[0], Double.parseDouble(eachBook[1]), Integer.parseInt(eachBook[2])));
						bookNumber--;
					}
					bookshelfs--;
					c++;
				}
				int clients=Integer.parseInt(br.readLine());
				while(clients>0) {
					String client=br.readLine();
					String[] clientParts=client.split(" ");
					Client clientO=new Client(clientParts[0]);
					for(int i=1;i<clientParts.length;i++) {
						clientO.getBooksList().push(new Book(clientParts[i]));
					}
					lib.getClients().offer(clientO);
					clients--;
				}
				cases--;
			}
			br.close();
		}catch(Exception e) {
			
		}
		if(flag==false) {
			try {
				lib.buyBook();
				lib.writeOutput();
			} catch (NoBookException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Library getLib() {
		return lib;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
