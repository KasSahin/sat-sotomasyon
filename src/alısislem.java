import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
public class alısislem {
    
    private Connection con=null;
    private Statement statement =null;
    private PreparedStatement preparedStatement=null;
    
    public void aracsil(int id) 
            //veri tabanından araç silme işleminin yaapıldığı sorgu.
    {
     String sorgu="Delete from alis where id=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(alısislem.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
    
    }
   // araç ekleme sorgusu 
   public void aracekle( String marka, String model, String fiyat, String tarih,String  odeme) {
        String sorgu = "INSERT INTO alis( marka, model, fiyat, tarıhg,ÖDEMEBILGI) VALUES( ?, ?, ?, ?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            //preparedStatement.setInt(1, id);
            preparedStatement.setString(1, marka);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, fiyat);
            preparedStatement.setString(4, tarih);
            preparedStatement.setString(5, odeme);
            preparedStatement.executeUpdate();
       
        }
        catch (SQLException ex)
        {
          Logger.getLogger(alısislem.class.getName()).log(Level.SEVERE, null, ex);
        
        
        }
    
    
    
    
    
    
    }
    
    
    
    public void aracguncelle(int id, String yenimarka,String yenimodel,String yenifiyat,String yenitarih,String yeniodeme)
     // günceleme işleminin yapılması araç güncelleme sorgusu 
    {
      String sorgu="UPDATE alis set marka=? , model=? , fiyat=? , tarıhg=? , ÖDEMEBILGI=? where id=?";
      
      try{
      preparedStatement=con.prepareStatement(sorgu);
     
      preparedStatement.setString(1, yenimarka);
      preparedStatement.setString(2, yenimodel);
      preparedStatement.setString(3, yenifiyat);
      preparedStatement.setString(4, yenitarih);
      preparedStatement.setString(5, yeniodeme);
       preparedStatement.setInt(6,id);
      
      preparedStatement.executeUpdate();
       
      
      
      
      } 
      catch(SQLException ex)
      {
        Logger.getLogger(alısislem.class.getName()).log(Level.SEVERE,null, ex);
          
          
          
      
      
      }
    
    
    
    
    
    
    
    }
    
    
    
    
    
    //alis tablosunu çekme işlemi 
    public ArrayList<alıs>alinangetir(){
        ArrayList<alıs> cikti=new ArrayList<alıs>();
        try{
        statement=con.createStatement();
        String sorgu="SELECT*FROM alis";
        ResultSet rs=statement.executeQuery(sorgu);
        while(rs.next())
        {
         int İd=rs.getInt("id");
         String Marka=rs.getString("marka");
         int  Model=rs.getInt("model");
         int Fiyat=rs.getInt("fiyat");
         String Tarih=rs.getString("tarihg");
         String Odeme=rs.getString("ÖDEMEBILGI");
         cikti.add(new alıs(İd,Marka,Model,Fiyat,Tarih,Odeme));
        
        
        }
        
         return cikti;
        
        
        
        }catch(SQLException ex)
        {
         Logger.getLogger(alısislem.class.getName()).log(Level.SEVERE,null,ex);
        
        
        }
        return null;
        
        
        
        
    } 
    // admin tablosundan giriş yapma 
    public boolean girisYap(String kullanici_adi,String parola)
    {
     String sorgu="SELECT*FROM adminler where username=? and password=?";
     
     
     try{
     preparedStatement =con.prepareStatement(sorgu);
     preparedStatement.setString(1,kullanici_adi);
     preparedStatement.setString(2, parola);
     ResultSet rs=preparedStatement.executeQuery();
     if(rs.next()==false)
     {
      return false;
     
     }
     else{return true;}
     
     
     }catch(SQLException ex)
     {
      Logger.getLogger(alısislem.class.getName()).log(Level.SEVERE,null,ex);
       
     
     }
        return false;
      
    
    
    
    }
    // veri tabanına bağlantı kontrolünün yapıldığı yer 
    public alısislem()
    {
       this.preparedStatement = null;
        // Veri tabanına bağlantı.
       String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db + "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı ....");
        }
        try {
            con = DriverManager.getConnection(url, database.kullaniciAdi,database.parola);
            System.out.println("Bağlantı başarılı");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      
    
       
           }   public static void main(String[] args){
               alısislem islemler=new alısislem();
       }
  
    }
