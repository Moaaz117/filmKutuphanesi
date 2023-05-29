import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner klavye = new Scanner(System.in);
        FilmYonetimi filmYonetimi = new FilmYonetimi();
        boolean durum = true;
        boolean durum2 = true;
        int secim1 = 0;
        int secim2 = 0;
        while (durum) {
            System.out.println("Hangi işlemi yapmak istiyorsunuz?\n1:Film ekleme  2:Film silme  3:Film düzenleme  4:Film arama  5:Filmleri listele");
            boolean durum4 = true;
            while (durum4) {
                String giris =klavye.nextLine();
                try {
                    secim1=(Integer.parseInt(giris));
                    durum4 = false;
                } catch (NumberFormatException e) {
                    System.out.println("Sayı giriniz!");
                }
            }
            switch (secim1) {
                case 1:
                    filmYonetimi.FilmEkleme();
                    durum2 = true;
                    break;
                case 2:
                    filmYonetimi.FilmSilme();
                    durum2 = true;
                    break;
                case 3:
                    filmYonetimi.FilmDuzenleme();
                    durum2 = true;
                    break;
                case 4:
                    filmYonetimi.FilmArama();
                    durum2 = true;
                    break;
                case 5:
                    filmYonetimi.FilmListeleme();
                    durum2 = true;
                    break;
                default:
                    System.out.println("Geçersiz giriş yaptınız.");
                    durum2 = true;
            }
            while (durum2){
                System.out.println("Başka işleminiz var mı?\n1:Evet  2:Hayır");
                boolean durum3 = true;
                while (durum3) {
                    String giris =klavye.nextLine();
                    try {
                        secim2=(Integer.parseInt(giris));
                        durum3 = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Sayı giriniz!");
                    }
                }
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
