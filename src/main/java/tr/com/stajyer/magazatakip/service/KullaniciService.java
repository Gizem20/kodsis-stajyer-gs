package tr.com.stajyer.magazatakip.service;

import tr.com.stajyer.magazatakip.dao.KullaniciDao;
import tr.com.stajyer.magazatakip.domain.Kullanici;

/**
 * Created by scinkir on 25.06.2015.
 */
public class KullaniciService {
    KullaniciDao kullaniciDao;

    public KullaniciService() {
        kullaniciDao=new KullaniciDao();
    }

    public boolean kullaniciGiris(Kullanici kullanici) {
        return kullaniciDao.girisYap(kullanici);
    }
}