import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilmYonetimi filmYonetimi = new FilmYonetimi();
        boolean durum = true;
        boolean durum2 = true;
        int secim1;
        int secim2;
        while (durum) {
            System.out.println("Hangi işlemi yapmak istiyorsunuz?\n1:Film ekleme  2:Film silme  3:Film düzenleme  4:Film arama  5:Filmleri listele");
            Scanner klavye = new Scanner(System.in);
            secim1 = klavye.nextInt();
            switch (secim1) {
                case 1:
                    filmYonetimi.FilmEkleme();
                    break;
                case 2:
                    filmYonetimi.FilmSilme();
                    break;
                case 3:
                    filmYonetimi.FilmDuzenleme();
                    break;
                case 4:
                    filmYonetimi.FilmArama();
                    break;
                case 5:
                    filmYonetimi.FilmListeleme();
                    break;
                default:
                    System.out.println("Geçersiz giriş yaptınız.");
            }
            while (durum2){
                System.out.println("Başka işleminiz var mı?\n1:Evet  2:Hayır");
                secim2 = klavye.nextInt();
                switch (secim2) {
                    case 1:
                        durum2 = false;
                        break;
                    case 2:
                        System.out.println("Teşekkür ederiz. İyi günler :)");
                        durum = false;
                        durum2 = false;
                        break;
                    default:
                        System.out.println("Geçersiz giriş yaptınız.");


                }
            }
        }
    }
}