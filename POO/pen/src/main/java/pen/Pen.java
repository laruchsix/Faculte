package pen;

import java.awt.Color;

public class Pen {

    private Cartridge cartridge;
    private final Cap CAP;

    public Pen() {
        this.cartridge = new Cartridge(Color.blue);
        this.CAP = new Cap();
    }

    public Pen(String m) {
        this.cartridge = new Cartridge(Color.blue);
        this.CAP = new Cap(m);
    }

    //removes the cartridge
    public void freeCart() {
        if(this.cartridge != null){
            Cartridge c = this.getCartridge();
            this.cartridge = null;
            if(c.getPen() != null )
                c.freePen();
        }
    }

    public void changeCartridge(Cartridge c) {
        this.freeCart();
        this.cartridge = c;
        if(this.cartridge.getPen() != this)
            this.cartridge.setPen(this);
    }

    public boolean write(String text) {
        return this.cartridge.getLevel() > 0;
    }

    public Cartridge getCartridge() {
        return this.cartridge;
    }

}
