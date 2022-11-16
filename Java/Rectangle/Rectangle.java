package Downloads;

public class Rectangle {
    private int x, y, width, height;

    public static void main(String[] args) {
        Rectangle test=new Rectangle(3,3,3);
        Rectangle copy=copy(test);
        Rectangle rechteck=new Rectangle(5,2,2,1);
        Rectangle schnitt=intersection(test,copy,rechteck);
        System.out.println(schnitt);
    }

    /**
     * Liefert die Breite des Rechtecks.
     * @return Gibt die Breite des Rechtecks.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setzt die Breite des Rechtecks auf einen neuen Wert.
     * @param widthIn Wert der neuen Breite des Rechtecks.
     */
    public void setWidth(int widthIn) {
        if (widthIn > 0) {
            this.width = widthIn;
        } else {
            Utils.error("Fehler");
        }
    }

    /**
     * Liefert die Höhe des Rechtecks.
     * @return Gibt die Höhe des Rechtecks.
     */
    public int getHeight() {
        return x;
    }

    /**
     * Setzt die Höhe des Rechtecks auf einen neuen Wert.
     * @param heightIn Wert der neuen Höhe des Rechtecks.
     */
    public void setHeight(int heightIn) {
        if (heightIn > 0) {
            this.height = heightIn;
        } else {
            Utils.error("Fehler");
        }
    }
    
    /**
     * Liefert die y-Koordinate der oberen Kante des Rechtecks.
     * @return Gibt die y-Koordinate des Rechtecks aus.
     */
    public int getY() {
        return y;
    }

    /**
     * Setzt die y-Koordinate der oberen Kante des Rechtecks auf einen neuen Wert.
     * @param yIn Wert der neuen y-Koordinate des Rechtecks.
     */
    public void setY(int yIn) {
        if (yIn > 0) {
            this.y = yIn;
        } else {
            Utils.error("Fehler");
        }

    }

    /**
     * Liefert die x-Koordinate der linken Kante des Rechtecks.
     * @return Gibt die x-Koordinate des Rechtecks aus.
     */
    public int getX() {
        return x;
    }

    /**
     * Setzt die x-Koordinate der linken Kante des Rechtecks auf einen neuen Wert.
     * @param xIn Wert der neuen x-Koordinate des Rechtecks.
     */
    public void setX(int xIn) {
        if (xIn > 0) {
            this.x = xIn;
        } else {
            Utils.error("Fehler");
        }
    }

    /**
     * Erstellt ein neues Rechteck mit den Koordinaten der linken, oberen Ecke und den Seitenlängen des Rechtecks.
     * @param xInput x-Koordinate der linken, oberen Ecke.
     * @param yInput y-Koordinate der linken, oberen Ecke.
     * @param widthInput Breite des Rechtecks.
     * @param heightInput Höhe des Rechtecks.
     */
    public Rectangle(int xInput, int yInput, int widthInput, int heightInput) {
        if (width >= 0 && height >= 0 && xInput > 0 && yInput > 0) {
            this.setX(xInput);
            this.setY(yInput);
            this.setHeight(heightInput);
            this.setWidth(widthInput);
        } else {
            Utils.error("Fehler");
        }
    }

    /**
     * Erstellt ein neues Quadrat mit den Koordinaten der linken, oberen Ecke und der Seitenlänge des Quadrats.
     * @param xInput x-Koordinate der linken, oberen Ecke.
     * @param yInput y-Koordinate der linken, oberen Ecke.
     * @param sidelengthInput Seitenlänge des Quadrats.
     */
    public Rectangle(int xInput, int yInput, int sidelengthInput) {
        if (width >= 0 && height >= 0 && xInput > 0 && yInput > 0) {
            this.setX(xInput);
            this.setY(yInput);
            this.setHeight(sidelengthInput);
            this.setWidth(sidelengthInput);
        } else {
            Utils.error("Fehler");
        }
    }

    /**
     * 
     * @param toCopy
     * @return
     */
    public static Rectangle copy(Rectangle toCopy) {
        return new Rectangle(toCopy.getX(), toCopy.getY(), toCopy.width, toCopy.height);
    }

    /**
     * Die Methode stellt fest, ob die uebergebenden Rechtecke alle Quadrate sind.
     * 
     * @param rectangles Gibt der Methode mehrere Rechtecke, um festzustellen, ob
     *                   diese alle Quadrate sind.
     * @return Gibt "true" aus, wenn alle uebergebenden Rechtecke Quadrate sind,
     *         sonst gibt "false" aus.
     */
    public static boolean areSquares(Rectangle... rectangles) {
        boolean isSquare = true;
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i].getWidth() != rectangles[i].getHeight()) {
                isSquare = false;
            }
        }
        return isSquare;
    }

    /**
     * Die Methode berechnet den Flaecheninhalt des Rechteck-Objekts.
     * @return Gibt Flaecheninhalt als int-Wert aus.
     */
    public int area() {
        return this.getHeight() * this.getWidth();

    }

    /**
     * Die Methode gibt das größte Rechteck zurück, das vollständig in allen als
     * Argument übergebenen Rechtecken enthalten ist. Wenn rectangles leer ist, soll
     * null zurückgegeben werden. Falls der Schnitt der Rechtecke leer ist, soll
     * ebenfalls null zurückgegeben werden.
     * @param rectangles Gibt der Methode mehrere Rechtecke, um den größten
     *                   gemeinsamen Schnitt zu berechnen.
     * @return Gibt Rechteck mit größten gemeinsamen Schnitt aus.
     */
    public static Rectangle intersection(Rectangle... rectangles) {
        Rectangle ausgabe = null;
        if (rectangles != null) {
            ausgabe = rectangles[0];
        }
        for (int i = 1; i < rectangles.length; i++) {
            ausgabe = calculateOverlap(ausgabe, rectangles[i]);
        }
        return ausgabe;
    }

    /**
     * Die Methode berechnet den Schnitt zweier Rechtecke.
     * 
     * @param rect1 Erstes Rechteck-Objekt, um den Schnitt zu berechnen.
     * @param rect2 Zweites Rechteck-Objekt, um den Schnitt zu berechnen.
     * @return Gibt den Schnitt als neues Rechteck mit allen dazugehörigen Wertenm
     *         aus.
     */
    public static Rectangle calculateOverlap(Rectangle rect1, Rectangle rect2) {
        if (rect1 == null || rect2 == null) {
            return null;
        }
        int linksX1 = rect1.getX();
        int rechtsX1 = rect1.getX() + rect1.getWidth();
        int obenY1 = rect1.getY();
        int untenY1 = rect1.getY() - rect1.getHeight();

        int linksX2 = rect2.getX();
        int rechtsX2 = rect2.getX() + rect2.getWidth();
        int obenY2 = rect2.getY();
        int untenY2 = rect2.getY() - rect2.getHeight();

        if (rechtsX1 > linksX2 && rechtsX2 > linksX1 && obenY1 > untenY2 && obenY2 > untenY1) {
            int neuX = Utils.max(linksX1, linksX2);
            int neuY = Utils.min(obenY1, obenY2);
            int neuWidth = Utils.min(rechtsX1 - linksX2, rechtsX2 - linksX1);
            int neuHeight = Utils.min(obenY1 - untenY2, obenY2 - untenY1);

            return new Rectangle(neuX, neuY, neuWidth, neuHeight);
        } else {
            return null;
        }
    }

    /**
     * Die Methode erstellt eine textuelle Repräsentation des aktuellen Rechtecks.
     * Dies geschieht über die Eckpunkte des Rechtecks, die, beginnend bei der
     * oberen linken Ecke, gegen den Uhrzeigersinn ausgegeben werden sollen.
     * 
     * @return Gibt String der Form (x|y),(x|y),(x|y),(x|y) zurück wobei x und y
     *         jeweils für Eckpunkte des Rechteck-Objekt stehen.
     */
    public String toString() {

        String teil1 = "(" + this.x + "|" + this.y + "),";
        String teil2 = "(" + this.x + "|" + (this.y - this.height) + "),";
        String teil3 = "(" + (this.x + this.width) + "|" + (this.y - this.height) + "),";
        String teil4 = "(" + (this.x + this.width) + "|" + this.y + ")";

        return teil1 + teil2 + teil3 + teil4;
    }
}
