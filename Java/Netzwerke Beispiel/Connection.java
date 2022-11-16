import java.net.*;
import java.io.*;

/**
 * <p>Materialien zu den zentralen
 * Abiturpruefungen im Fach Informatik ab 2012 in
 * Nordrhein-Westfalen.</p>
 * <p>Klasse Connection</p>
 * <p>Objekte der Klasse Connection ermoeglichen eine Netzwerkverbindung mit
 * dem TCP/IP-Protokoll. Es koennen nach Verbindungsaufbau zu einem Server
 * Zeichenketten (Strings) gesendet und empfangen werden. Zur Vereinfachung
 * geschieht dies zeilenweise, d. h., beim Senden einer Zeichenkette wird ein
 * Zeilentrenner ergänzt und beim Empfangen wird er entfernt.</p>
 *
 * <p>NW-Arbeitsgruppe: Materialentwicklung zum Zentralabitur
 * im Fach Informatik</p>
 *
 * @version 2011-12-12
 */
public class Connection extends Thread {
  private Socket s;
  private BufferedReader vomHost;
  private PrintWriter zumHost;
  private String serverName;
  private int port;

  /** 
   * Es wird eine Verbindung zum durch IP-Adresse und Portnummer angegebenen
   *  Server aufgebaut, so dass Daten gesendet und empfangen werden koennen.
   */
  public Connection(String serverName, int port){
    this.serverName = serverName;
    this.port = port;
    connect();
  }

  public Connection(Socket socket) {
    s = socket;
    port=s.getLocalPort();
    try {
      //Objekt zum Versenden von Nachrichten ueber den Socket erzeugen
      zumHost = new PrintWriter(s.getOutputStream(), true);
      //Objekt zum Empfangen von Nachrichten ueber das Socketobjekt erzeugen
      vomHost= new BufferedReader(new InputStreamReader(s.getInputStream()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String connect() {
    try {
      s = new Socket(serverName,port);
      //Objekt zum Versenden von Nachrichten ueber den Socket erzeugen
      zumHost = new PrintWriter(s.getOutputStream(), true);
      //Objekt zum Empfangen von Nachrichten ueber das Socketobjekt erzeugen
      vomHost= new BufferedReader(new InputStreamReader(s.getInputStream()));
      return "Verbindung : " + s;
    } catch (Exception e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }

  /** 
   * Es wird auf eine eingehende Nachricht vom Server gewartet und diese
   * Nachricht zurückgegeben, wobei der vom Server angehängte Zeilentrenner
   * entfernt wird. Während des Wartens ist der ausführende Prozess blockiert.
   */
  public String receive() {
    try {
      return vomHost.readLine();
    }
    catch ( IOException e) {
      System.out.println("Verbindung zu " + getRemoteIP() + " " + getLocalPort() + " ist unterbrochen");
    }
    return null;
  }

  /** 
   * Die angegebene Nachricht pMessage wird - um einen Zeilentrenner erweitert -
   * an den Server versandt.
   */
  public void send(String nachricht) {
    zumHost.println(nachricht);
    zumHost.flush();
  }

  public boolean isConnected() {
    return s.isConnected();
  }

  public boolean isClosed() {
    return s.isClosed();
  }

  public String getRemoteIP() {
    return "" + s.getInetAddress().getHostAddress();
  }

//  public String getLocalIP() {
//    return "" + s.getLocalAddress();
//  }
//
  public int getRemotePort() {
    return s.getPort();
  }

  public int getLocalPort() {
    return s.getLocalPort();
  }

  public void close() {
    try {
      s.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Socket verbindungsSocket() {
    return s;
  }
}

