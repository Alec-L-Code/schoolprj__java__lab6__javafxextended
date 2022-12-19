package app;
/**
 * Alec Lund
 * 4/7
 * A random image generator of heiroglyphics with a reload button.
 */
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lund_lab6a extends Application implements EventHandler<ActionEvent> {
  private Button reloadButton;
  private GridPane grid;
  private Stage mainStage;
  @Override
  public void start(Stage primaryStage) 
  {
    this.mainStage = primaryStage;
    draw(mainStage).show();
  }
  public static void main(String[] args) 
  { 
    launch(args);
  }
  public Stage draw(Stage stage)
  {
    grid = new GridPane();
    reloadButton = new Button("Reload");
    reloadButton.autosize();
    Random random = new Random();
    for(int i = 0; i < 3; i++)
    {
      int rand = random.nextInt(61);
      Image glyph = new Image("file:src/app/Images/Hieroglyphics/" + rand + ".png");
      ImageView iv = new ImageView(glyph);
      iv.autosize();
      grid.add(iv, i, 0);
    }
    reloadButton.setOnAction(this);
    grid.add(reloadButton, 3, 0);
    stage.setScene(new Scene(grid));
    return stage;
  }
  @Override
  public void handle(ActionEvent arg0) 
  {
    if(arg0.getSource() == reloadButton)
    {
      draw(mainStage).show();
    }
  }
}
