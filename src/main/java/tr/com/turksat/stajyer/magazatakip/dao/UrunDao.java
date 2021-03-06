package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Urun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UrunDao {

        public Urun urunEkle(Urun urun) {
            Connection con = null;
            PreparedStatement ps = null;
            String query = "insert into Urun (id,urun_tanim_id,urun_fiyat,urun_adet,baslangic_urun_sayisi,iade_durumu) values(?,?,?,?,?,?)";
            try {
                con = Database.getInstance().getConnection();
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, urun.getId());
                preparedStmt.setInt(2, urun.getUrunTanimiId());
                preparedStmt.setInt(3, urun.getUrunFiyat());
                preparedStmt.setInt(4, urun.getUrunAdet());
                preparedStmt.setInt(5, urun.getBaslangicUrunSayisi());
                preparedStmt.setString(6, urun.getIadeDurumu());


                preparedStmt.executeUpdate(query);
                System.out.println("Bilgiler tabloya eklendi");
            } catch (Exception ex) {
                System.out.println("Hatalı islem." + ex.getLocalizedMessage());
                return null;
            } finally {try {
                if (ps != null)
                    ps.close();
            } catch (Exception ex1) {
            }// nothing we can do
                try {if (con != null)
                    con.close();
                } catch (Exception ex2) {
                    ex2.printStackTrace();}//end finally try
                Database.close(con);
            } return urun;
        }

        public List<Urun> getUrun() {

            Connection con = null;
            PreparedStatement ps = null;
            List<Urun> urunList = new ArrayList<>();
            try {  con = Database.getInstance().getConnection();
                ps = con.prepareStatement(
                        "select * from urun");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) // found
                {
                    Urun urun = new Urun();
                    urun.setId(rs.getInt(1));
                    urun.setUrunTanimiId(rs.getInt(2));
                    urun.setUrunFiyat(rs.getInt(3));
                    urun.setUrunAdet(rs.getInt (4));
                    urun.setBaslangicUrunSayisi(rs.getInt(5));
                    urun.setIadeDurumu(rs.getString(6));

                    urunList.add(urun);
                }
            } catch (Exception e) {
                System.out.println("Hatalı islem.");
            } finally {
                try {
                    if (ps != null)
                        ps.close();
                }
                catch (Exception e1) {
                }// nothing we can do
                try {
                    if (con != null)
                        con.close();
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }//end finally try
            }
            return urunList;
        }

        public boolean  urunSil(Urun urun) {
            Connection con = null;
            PreparedStatement ps = null;

            try {  con = Database.getInstance().getConnection();
                ps = con.prepareStatement ("delete from urun where id= ?");

            } catch (Exception ex) {
                System.out.println("hatalı islem");
            } finally {
                try {
                    if (ps != null)
                        ps.close();
                } catch (Exception se2) {
                }// nothing we can do
                try {
                    if (con != null)
                        con.close();
                } catch (Exception se) {
                    se.printStackTrace();
                }//end finally try
            }return false;
        }
}
