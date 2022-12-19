package app;
/**
 * Alec Lund
 * 4/7
 * A basic calculator with decent functionality and restrictions on errors
 */
import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Lund_lab6b extends Application implements EventHandler<ActionEvent>
{
    private Stage mainStage;
    private TextField output;
    private GridPane buttonsPane;
    private ArrayList<Button> buttons = new ArrayList<>(); // 0 1 2 3 4 5 6 7 8 9 + * - / = del clear (all buttons will be in this array) (17) 4x5 Grid
    @Override
    public void start(Stage primaryStage) 
    {
        this.mainStage = primaryStage;
        InitializeButtons();
        drawCalculator(mainStage).show();
    }
    public static void main(String[] args) 
    { 
        launch(args);
    }
    @Override
    public void handle(ActionEvent arg0) 
    {
        for(Button b : buttons)
        {
            if(arg0.getSource() == b)
            {
                switch(b.getId())
                {
                    case "=":
                    if(output.getText().equals("0")) { continue; }
                    else if(output.getText().charAt(output.getText().length() - 1) == '/' ||
                    output.getText().charAt(output.getText().length() - 1) == '*' ||
                    output.getText().charAt(output.getText().length() - 1) == '+' ||
                    output.getText().charAt(output.getText().length() - 1) == '-') { continue; }
                    else
                    {
                        ScriptEngineManager manager = new ScriptEngineManager();
                        ScriptEngine eng = manager.getEngineByName("js");
                        try
                        {
                            Object result = eng.eval(output.getText());
                            output.setText("" + result);
                        } catch(ScriptException e) { System.out.println(e.getMessage()); }
                    }
                    break;
                    case "del":
                    if(output.getText().length() >= 2)
                    {
                        output.setText(output.getText().substring(0, output.getText().length() - 1));
                    }
                    if(output.getText().length() == 1)
                    {
                        output.setText("0");
                    }
                    break;
                    case "clear":
                    output.setText("0");
                    break;
                    case "/":
                    if(output.getText().equals("0")) { continue; }
                    else if(output.getText().charAt(output.getText().length() - 1) == '/' ||
                    output.getText().charAt(output.getText().length() - 1) == '*' ||
                    output.getText().charAt(output.getText().length() - 1) == '+' ||
                    output.getText().charAt(output.getText().length() - 1) == '-') { continue; }
                    else { output.setText(output.getText() + "/"); }
                    break;
                    case "*":
                    if(output.getText().equals("0")) { continue; }
                    else if(output.getText().charAt(output.getText().length() - 1) == '/' ||
                    output.getText().charAt(output.getText().length() - 1) == '*' ||
                    output.getText().charAt(output.getText().length() - 1) == '+' ||
                    output.getText().charAt(output.getText().length() - 1) == '-') { continue; }
                    else { output.setText(output.getText() + "*"); }
                    break;
                    case "-":
                    if(output.getText().equals("0")) { continue; }
                    else if(output.getText().charAt(output.getText().length() - 1) == '/' ||
                    output.getText().charAt(output.getText().length() - 1) == '*' ||
                    output.getText().charAt(output.getText().length() - 1) == '+' ||
                    output.getText().charAt(output.getText().length() - 1) == '-') { continue; }
                    else { output.setText(output.getText() + "-"); }
                    break;
                    case "+":
                    if(output.getText().equals("0")) { continue; }
                    else if(output.getText().charAt(output.getText().length() - 1) == '/' ||
                    output.getText().charAt(output.getText().length() - 1) == '*' ||
                    output.getText().charAt(output.getText().length() - 1) == '+' ||
                    output.getText().charAt(output.getText().length() - 1) == '-') { continue; }
                    else { output.setText(output.getText() + "+"); }
                    break;
                    case "0":
                    if(output.getText().charAt(output.getText().length() - 1) == '/') { continue; } // Divide by zero block.
                    if(!output.getText().equals("0")) { output.setText(output.getText() + "0"); }
                    break;
                    case "1":
                    if(output.getText().equals("0")) { output.setText("1"); }
                    else { output.setText(output.getText() + "1"); }
                    break;
                    case "2":
                    if(output.getText().equals("0")) { output.setText("2"); }
                    else { output.setText(output.getText() + "2"); }
                    break;
                    case "3":
                    if(output.getText().equals("0")) { output.setText("3"); }
                    else { output.setText(output.getText() + "3"); }
                    break;
                    case "4":
                    if(output.getText().equals("0")) { output.setText("4"); }
                    else { output.setText(output.getText() + "4"); }
                    break;
                    case "5":
                    if(output.getText().equals("0")) { output.setText("5"); }
                    else { output.setText(output.getText() + "5"); }
                    break;
                    case "6":
                    if(output.getText().equals("0")) { output.setText("6"); }
                    else { output.setText(output.getText() + "6"); }
                    break;
                    case "7":
                    if(output.getText().equals("0")) { output.setText("7"); }
                    else { output.setText(output.getText() + "7"); }
                    break;
                    case "8":
                    if(output.getText().equals("0")) { output.setText("8"); }
                    else { output.setText(output.getText() + "8"); }
                    break;
                    case "9":
                    if(output.getText().equals("0")) { output.setText("9"); }
                    else { output.setText(output.getText() + "9"); }
                    break;
                }
            }
        }
    }

    public Stage drawCalculator(Stage s)
    {
        Group g = new Group();
        g.prefWidth(350);
        g.prefHeight(350);
        output = new TextField();
        output.setText("0");
        output.setEditable(false);
        output.setPrefSize(350, 25);
        output.setAlignment(Pos.TOP_CENTER);
        int buttonIndex = 0;
        buttonsPane = new GridPane();
        buttonsPane.autosize();
        buttonsPane.setPrefSize(350, 350);
        buttonsPane.alignmentProperty().set(Pos.BOTTOM_CENTER);
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(i == 5 && j == 2) { continue; }
                buttonsPane.add(buttons.get(buttonIndex), j, i);
                buttonIndex++;
            }
        }
        g.getChildren().addAll(buttonsPane, output);
        s.setScene(new Scene(g, 350, 350));
        return s;
    }
    public void InitializeButtons() // Create the buttons in this method
    {
        for(int i = 0; i < 10; i++)
        {
            Button b = new Button("" + i);
            b.setId("" + i);
            b.autosize();
            b.setPrefSize(40, 40);
            b.setOnAction(this);
            buttons.add(b);
        }
        Button add = new Button("+");
        add.setId("+");
        add.autosize();
        add.setPrefSize(40, 40);
        add.setOnAction(this);
        buttons.add(add);

        Button multiply = new Button("*");
        multiply.setId("*");
        multiply.autosize();
        multiply.setPrefSize(40, 40);
        multiply.setOnAction(this);
        buttons.add(multiply);

        Button subtract = new Button("-");
        subtract.setId("-");
        subtract.autosize();
        subtract.setPrefSize(40, 40);
        subtract.setOnAction(this);
        buttons.add(subtract);

        Button divide = new Button("/");
        divide.setId("/");
        divide.autosize();
        divide.setPrefSize(40, 40);
        divide.setOnAction(this);
        buttons.add(divide);

        Button compute = new Button("=");
        compute.setId("=");
        compute.autosize();
        compute.setPrefSize(40, 40);
        compute.setOnAction(this);
        buttons.add(compute);
        
        Button delete = new Button("delete");
        delete.setId("del");
        delete.autosize();
        delete.setPrefSize(60, 40);
        delete.setOnAction(this);
        buttons.add(delete);
        
        Button clear = new Button("clear");
        clear.setId("clear");
        clear.autosize();
        clear.setPrefSize(60, 40);
        clear.setOnAction(this);
        buttons.add(clear);
    }
}
