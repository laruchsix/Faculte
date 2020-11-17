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
        if(this.pen != null){
            Pen p = this.getPen();
            this.pen = null;
            if(p.getCartridge() != null)
                p.freeCart();
        }
    }

    public void setPen(Pen p) {
        this.freePen();
        this.pen = p;
        if(p.getCartridge() != this )
            p.changeCartridge(this);
    }

    public void use() {
        if(this.level > 0)
            this.level --;
    }

    public boolean isEmpty() {
        return (this.level == 0) ;
    }

    Pen getPen() {
        return this.pen;
    }

    public int getLevel() {
        return this.level;
    }
}
