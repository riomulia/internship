import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {

	// Basis Data untuk menyimpan himpunan kalimat dari KBBI
	private static final String[] database_word = new String[] { "abadi",
			"kekal", "abang", "habis", "tepung", "bakso", "bibit", "penyakit",
			"bantai", "cacing", "calon", "camar", "jenazah", "plastik",
			"katak", "aktif", "fakta", "cantik", "komisi", "menteri", "tenaga",
			"kerja", "gempa", "burung", "hasil", "komputer", "veritrans",
			"infeksi", "jauh", "dekat", "celana", "kursi", "meja"};

	public static void main(String[] args) throws IOException {

		Random randomGenerator = new Random();

		// buffered Reader untuk scan input
		BufferedReader scan = new BufferedReader(new InputStreamReader(
				System.in));

		int t = randomGenerator.nextInt(database_word.length);
		String jawaban = database_word[t];
		
		//Memanggil method untuk shuffle kata
		String soal = shuffle(jawaban);
		System.out.println("Tebak Kata : " + soal); // shuffle the word
		System.out.print("Jawab: ");
		
		//Membaca tebakan user
		String tebakan = scan.readLine();

		//Print hasil
		String hasil = "SALAH! Silakan coba lagi";
		if (result(jawaban, tebakan)) {
			hasil = "BENAR!";
		}
		System.out.println(hasil);
	}

	public static boolean result(String jawaban, String tebakan) {

		return jawaban.equalsIgnoreCase(tebakan); // IgnoreCase untuk menyamakan
													// setiap huruf input

	}

	public static String shuffle(String word) {

		String shuffledString = "";

		while (word.length() > 0) {
			int index = (int) Math.floor(Math.random() * word.length());
			char c = word.charAt(index);
			word = word.substring(0, index) + word.substring(index + 1);
			shuffledString += c;
		}

		return shuffledString;

	}
}
