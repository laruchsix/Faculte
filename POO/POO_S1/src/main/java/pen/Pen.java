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
    }

    public void changeCartridge(Cartridge c) {
    }

    public boolean write(String text) {
        return false;
    }

    public Cartridge getCartridge() {
        return null;
    }

}
