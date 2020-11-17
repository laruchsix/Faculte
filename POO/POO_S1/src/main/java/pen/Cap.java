package pen;

public class Cap {

    public final String BRAND;
    public static final String DEFAULT_BRAND = "bic";

    public Cap(String m) {
      this.BRAND = m;
    }

    public Cap() {
        this.BRAND = this.DEFAULT_BRAND; 
    }
}
