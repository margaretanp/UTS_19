import java.util.Scanner;

public class HitungIP19 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
          System.out.print("Masukkan nama mahasiswa: ");
        String namaMahasiswa = input.nextLine();

        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMataKuliah = input.nextInt();
        input.nextLine();  // Membuang karakter newline.

        double totalIPKumulatif = 0;
        int totalSKS = 0;
        int mataKuliahRemidi = 0;

        for (int i = 1; i <= jumlahMataKuliah; i++) {
            System.out.print("Masukkan nama mata kuliah ke-" + i + ": ");
            String namaMataKuliah = input.nextLine();

            System.out.print("Masukkan nilai mata kuliah (A/B+/B/C+/C/D/E): ");
            String nilai = input.nextLine();

            System.out.print("Masukkan jumlah SKS mata kuliah: ");
            int sks = input.nextInt();
            input.nextLine();  // Membuang karakter newline.

            double nilaiIndeks = 0;

            // Konversi nilai ke indeks sesuai ketentuan.
            switch (nilai) {
                case "A":
                    nilaiIndeks = 4.0;
                    break;
                case "B+":
                    nilaiIndeks = 3.5;
                    break;
                case "B":
                    nilaiIndeks = 3.0;
                    break;
                case "C+":
                    nilaiIndeks = 2.5;
                    break;
                case "C":
                    nilaiIndeks = 2.0;
                    break;
                case "D":
                    nilaiIndeks = 1.0;
                    mataKuliahRemidi++;
                    break;
                case "E":
                    nilaiIndeks = 0.0;
                    mataKuliahRemidi++;
                    break;
                default:
                    System.out.println("Nilai tidak valid, masukkan A/B+/B/C+/C/D/E.");
                    i--;
                    continue;
            }

            double nilaiKumulatif = nilaiIndeks * sks;
            totalIPKumulatif += nilaiKumulatif;
            totalSKS += sks;
        }

        double ipMahasiswa = totalIPKumulatif / totalSKS;

        System.out.println("Nama Mahasiswa: " + namaMahasiswa);
        System.out.println("IP Mahasiswa: " + ipMahasiswa);
        System.out.println("Jumlah mata kuliah perbaikan/remidi: " + mataKuliahRemidi);

        input.close();
    }
}
