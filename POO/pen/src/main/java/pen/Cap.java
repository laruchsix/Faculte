package pen;

public class Cap {

    public final String BRAND;
    public static final String DEFAULT_BRAND = "bic";

    public Cap(String m) {
        if(m == null)
           this.BRAND = this.DEFAULT_BRAND;
        else 
            this.BRAND = m;
    }

    public Cap() {
        this.BRAND = this.DEFAULT_BRAND; 
    }
}
