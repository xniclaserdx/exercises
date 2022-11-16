
import java.awt.*;
import java.awt.event.*;

// Autor: %AUTHOR%
// Datum: %DATE%

public class Buchindex_GUI extends Frame {
  // Anfang Attribute
  private Label label1 = new Label();
  private TextField textField1 = new TextField();
  private Label label2 = new Label();
  private TextField textField2 = new TextField();
  private Button button1 = new Button();
  private Button button2 = new Button();
  private Button button3 = new Button();
  private TextArea textArea1 = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  // Ende Attribute
  private Buchindex index;

  public Buchindex_GUI(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 290;
    int frameHeight = 378;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten

    label1.setBounds(16, 16, 38, 16);
    label1.setText("Begriff");
    label1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    cp.add(label1);
    textField1.setBounds(88, 16, 121, 24);
    textField1.setText("Baum");
    cp.add(textField1);
    label2.setBounds(16, 56, 31, 16);
    label2.setText("Seite");
    label2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    cp.add(label2);
    textField2.setBounds(88, 56, 121, 24);
    textField2.setText("12");
    cp.add(textField2);
    button1.setBounds(40, 96, 187, 25);
    button1.setLabel("Begriff einf�gen");
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button1_ActionPerformed(evt);
      }
    });
    cp.add(button1);
    button2.setBounds(40, 128, 187, 25);
    button2.setLabel("Testbelegung");
    button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button2_ActionPerformed(evt);
      }
    });
    cp.add(button2);
    button3.setBounds(40, 160, 187, 25);
    button3.setLabel("ausgeben");
    button3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        button3_ActionPerformed(evt);
      }
    });
    cp.add(button3);
    textArea1.setBounds(16, 200, 241, 121);
    textArea1.setText("(Strings)");
    cp.add(textArea1);
    // Ende Komponenten

    setResizable(false);
    setVisible(true);
    
    index= new Buchindex();
  }

  // Anfang Methoden
  public void button1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    index.insert(textField1.getText(),Integer.parseInt(textField2.getText()));
  }

  public void button2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    index.erzeugeTestbelegung();
  }

  public void button3_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    textArea1.setText(index.toString());
  }

  // Ende Methoden

  public static void main(String[] args) {
    new Buchindex_GUI("Buchindex_GUI");
  }
}