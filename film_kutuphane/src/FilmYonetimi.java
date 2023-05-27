import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmYonetimi {

    private ArrayList<String> ad;
    private ArrayList<String> yonetmen;
    private ArrayList<String> tur;
    private ArrayList<Integer> tarih;
    Scanner scanner;

    public FilmYonetimi() {

    }

    public void FilmEkleme() {
        scanner = new Scanner(System.in);
        if (ad == null) {
            ad = new ArrayList<>();
            yonetmen = new ArrayList<>();
            tur= new ArrayList<>();
            tarih= new ArrayList<>();
        }
        System.out.println("Film adı:");
        ad.add(scanner.nextLine());
        System.out.println("Film yönetmeni:");
        yonetmen.add(scanner.nextLine());
        System.out.println("Film türü:");
        tur.add(scanner.nextLine());
        boolean durum = true;
        while (durum) {
            System.out.println("Film tarihi");
            String tarih1 = scanner.nextLine();
            try {
                tarih.add(Integer.parseInt(tarih1));
                durum = false;
            } catch (NumberFormatException e) {
                System.out.println("Tarihi sayı olarak giriniz");
            }
        }
        System.out.println(" Film başarıyla eklendi.");
    }

    public void FilmSilme() {
        scanner = new Scanner(System.in);
        if (ad==null) {
            System.out.println("Kütüphane boş");
        }
        else {
            System.out.println("Silmek istediğiniz filmin adı:");
            String filmAdi = scanner.nextLine();
            boolean durum=false;
            for (int i = 0; i < ad.size(); i++) {
                if (ad.get(i).equals(filmAdi)) {
                    durum=true;
                }
            }
            if(durum){
                String filmYonetmeni =yonetmen.get(ad.indexOf(filmAdi));
                String filmTuru =tur.get(ad.indexOf(filmAdi));
                int filmTarihi =tarih.get(ad.indexOf(filmAdi));
                ad.remove(filmAdi);
                yonetmen.remove(filmYonetmeni);
                tur.remove(filmTuru);
                tarih.remove(tarih.indexOf(filmTarihi));
                System.out.println(" Film başarıyla silindi.");
            }else
                System.out.println("Film bulunamadı.");
        }
    }

    public void FilmListeleme() {
        if (ad == null||ad.isEmpty())
            System.out.println("Film kütüphanesi boş.");
        else {
            for (int i = 0; i < ad.size(); i++) {
                Yazdirma(i);
            }
        }
    }

    public void Yazdirma(int index) {
        System.out.println("Ad: " + ad.get(index) + ", Yönetmen: " +
                yonetmen.get(index) + ", Tür: " + tur.get(index)+", Tarih:"+tarih.get(index));
    }
    public void FilmArama() {
        scanner = new Scanner(System.in);
        boolean durum = true;
        while (durum){
            System.out.println("Arama türü seçin:\n1:İsime göre arama  2:Yönetmene göre arama  3:Film türüne göre arama  4:Tarihe göre arama");
            int secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    FilmAdArama();
                    durum = false;
                    break;
                case 2:
                    FilmYonetmenArama();
                    durum = false;
                    break;
                case 3:
                    FilmTurArama();
                    durum = false;
                    break;
                case 4:
                    FilmTarihArama();
                    durum = false;
                    break;
                default:
                    System.out.println("Geçersiz giriş.");
            }
        }
    }
    public void FilmDuzenleme() {
        scanner = new Scanner(System.in);
        boolean durum = true;
        while (durum){
            System.out.println("1:İsimi düzenle  2:Yönetmeni düzenle  3:Türü düzenle  4:Tarihi düzenle");
            int secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    FilmAdDuzenleme();
                    durum = false;
                    break;
                case 2:
                    FilmyonetmenDuzenleme();
                    durum = false;
                    break;
                case 3:
                    FilmTurDuzenleme();
                    durum = false;
                    break;
                case 4:
                    FilmTarihDuzenleme();
                    durum = false;
                default:
                    System.out.println("Geçersiz giriş.");
            }
        }
    }
    private void FilmAdArama() {
        scanner = new Scanner(System.in);
        if (ad==null||ad.isEmpty())
            System.out.println("Kütüphane boş");
        else{
            System.out.println("Aramak istediğiniz filmin adını giriniz:");
            String filmAdi = scanner.nextLine();
            int index=-1;
            for (int i = 0; i <= this.ad.size()-1; i++) {
                if (ad.get(i).equals(filmAdi)) {
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else
                Yazdirma(index);

        }
    }
    private void FilmYonetmenArama() {
        scanner = new Scanner(System.in);
        if (yonetmen==null||yonetmen.isEmpty())
            System.out.println("Kütüphane boş");
        else{
            System.out.println("Aramak istediğiniz filmin yönetmenini giriniz:");
            String filmYonetmeni = scanner.nextLine();
            int index=-1;
            for (int i = 0; i < yonetmen.size(); i++) {
                if (yonetmen.get(i).equals(filmYonetmeni)){
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else
                Yazdirma(index);

        }
    }
    private void FilmTurArama() {
        scanner = new Scanner(System.in);
        if (tur==null||tur.isEmpty())
            System.out.println("Kütüphane boş");
        else{
            System.out.println("Aramak istediğiniz filmin türünü giriniz:");
            String filmTuru = scanner.nextLine();
            int index=-1;
            for (int i = 0; i <= this.tur.size()-1; i++) {
                if (this.tur.get(i).equals(filmTuru)) {
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else
                Yazdirma(index);

        }
    }
    private void FilmTarihArama() {
        scanner = new Scanner(System.in);
        if (tarih==null||tarih.isEmpty()) {
            System.out.println("Kütüphane boş");
        }
        else{
            System.out.println("Aramak istediğiniz filmin türünü giriniz:");
            int filmTarihi = scanner.nextInt();
            int index=-1;
            for (int i = 0; i <= this.tarih.size()-1; i++) {
                if (this.tarih.get(i).equals(filmTarihi)) {
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else
                Yazdirma(index);

        }
    }


    private void FilmAdDuzenleme() {
        scanner = new Scanner(System.in);
        if (ad==null||ad.isEmpty()) {
            System.out.println("Kütüphane boş");
        }
        else{
            System.out.println("Filmin eski adını giriniz:");
            String eskiAd = scanner.nextLine();
            int index=-1;
            for (int i = 0; i <= this.ad.size()-1; i++) {
                if (this.ad.get(i).equals(eskiAd)){
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else{
                System.out.println("Yeni adı yazınız:");
                this.ad.set(index, scanner.nextLine());
                System.out.println("Film adı düzenlendi");
            }
        }
    }
    private void FilmyonetmenDuzenleme() {
        scanner = new Scanner(System.in);
        if (yonetmen==null||yonetmen.isEmpty()) {
            System.out.println("Kütüphane boş");
        }
        else{
            System.out.println("Değiştirmek istediğiniz filmin adı:");
            String filmAdi = scanner.nextLine();
            int index=-1;
            for (int i = 0; i <= this.ad.size()-1; i++) {
                if (this.ad.get(i).equals(filmAdi)) {
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else{
                System.out.println("Yeni yönetmeni yazınız:");
                this.yonetmen.set(index, scanner.nextLine());
                System.out.println("Film yönetmeni düzenlendi");
            }
        }
    }
    private void FilmTurDuzenleme() {
        scanner = new Scanner(System.in);
        if (tur==null||tur.isEmpty()) {
            System.out.println("Kütüphane boş");
        }
        else{
            System.out.println("Değiştirmek istediğiniz filmin adı:");
            String filmAdi = scanner.nextLine();
            int index=-1;
            for (int i = 0; i <= this.ad.size()-1; i++) {
                if (this.ad.get(i).equals(filmAdi)) {
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else{
                System.out.println("Yeni türü yazınız:");
                this.tur.set(index, scanner.nextLine());
                System.out.println("Film türü düzenlendi");
            }
        }
    }
    private void FilmTarihDuzenleme() {
        scanner = new Scanner(System.in);
        if (tarih==null||tarih.isEmpty()) {
            System.out.println("Kütüphane boş");
        }
        else{
            System.out.println("Değiştirmek istediğiniz filmin adı:");
            String filmAdi = scanner.nextLine();
            int index=-1;
            for (int i = 0; i <= this.tarih.size()-1; i++) {
                if (this.ad.get(i).equals(filmAdi)) {
                    index = i;
                }
            }if (index<0)
                System.out.println("Film bulunamadı");
            else{
                System.out.println("Yeni türü yazınız:");
                this.tarih.set(index, scanner.nextInt());
                System.out.println("Film tarihi düzenlendi");
            }
        }
    }
}
