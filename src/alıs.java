
public class alıs {
    
    private int id;
    private String marka;
    private int model;
    private int fiyat;
    private String tarih;  
    private String odeme;

// tarih should be String
   /* Object getMarka;
    Object getFiyat;
    Object getModel;
    Object getTarih;*/

    public alıs(int id, String marka, int model, int fiyat, String tarih,String odeme) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.fiyat = fiyat;
        this.tarih = tarih;
        this.odeme=odeme;
    }

    alıs(int İd, String Marka, int Model, int Fiyat, String Tarih) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getTarih() {  // Changed return type to String
        return tarih;
    }

    public void setTarih(String tarih) {  // Changed parameter type to String
        this.tarih = tarih;
    }
    public String getOdeme()
    {
    
      return odeme;
    
    }
    public void setOdeme(String odeme)
    {
      this.odeme=odeme;
    
    
    }
}
