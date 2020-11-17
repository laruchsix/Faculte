package pen;

import java.awt.Color;

public class Cartridge {

    public final static int DEFAULT_LEVEL = 3;
    private int level;
    private Pen pen = null;
    public final Color COLOR;

    public Cartridge(Color c) {
        this.level = this.DEFAULT_LEVEL;
        this.COLOR = c;
    }

    public void freePen() {
    }

    public void setPen(Pen p) {
    }

    public void use() {
    }

    public boolean isEmpty() {
        return true;
    }

    Pen getPen() {
        return null;
    }

    public int getLevel() {
        return -1;
    }
}
