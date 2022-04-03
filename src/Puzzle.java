import java.util.Scanner;
import java.io.*;

public class Puzzle {
    // Atribut
    static int id = 0;
    private Puzzle parrent;
    private int simpul;
	public int[][] matrix;
    private int cost;

	/* CONSTRUCTOR */
	public Puzzle() {	
        int i, j;
        this.parrent = null;
        id++;
        this.simpul = id;
		this.matrix = new int[4][4];
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				this.matrix[i][j] = 0;
			}
		}
        this.cost = 0;
	}

    public Puzzle(Puzzle p) {
        int i, j;
        id++;
        this.simpul = id;
        this.matrix = new int[4][4];
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				this.matrix[i][j] = p.matrix[i][j];
			}
		}
        this.cost = p.cost;
    }

    // Method
    public void bacaFile(String FileName) {
		// Membaca file eksternal kemudian dikonversi ke dalam atribut matrix
		try {
			String dir = "../test/" + FileName;
			File file = new File(dir);
			int i,j;

			Scanner input = new Scanner(file);
			for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    this.matrix[i][j] = Integer.parseInt(input.next());
                }
            }
            input.close();
            this.cost = this.calculateCost();
		// Jika tidak menemukan file
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Check your filename again.");
		}
	}	

	public void output() {
		// Mencetak puzzle ke layar
		int i, j;

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
                if (this.matrix[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(this.matrix[i][j] + " ");
                }
			}
			System.out.println();
		}
	}

    public Puzzle getParrent() {
        // Mengembalikan puzzle parrent
        return this.parrent;
    }

    public int getSimpul() {
        // Mengembalikan nilai simpul
        return this.simpul;
    }

    public void resetSimpul() {
        // Mengembalikan simpul ke 0 (Dalam GUI)
        id = 0;
    }

    public int getAllSimpul() {
        // Mengembalikan seluruh simpul yang sudah dibentuk
        return id;
    }

    public void kurangSimpul() {
        // Mengurangi simpul sejumlah 1
        id--;
    }

    public int getCost() {
        // Mengembalikan cost
        return this.cost;
    }

    public int getIdxCol(int row, int number) {
        // Mengembalikan index kolom dari number
        int j = 0;
        while (j < 4 && this.matrix[row][j] != number) {
            j++;
        }
        return j;
    }

    public int getIdxRow(int number) {
        // Mengembalikan index baris dari number
        int i = 0;
        while (i < 4 && getIdxCol(i, number) == 4) {
            i++;
        }
        return i;
    }

    public boolean isSame(Puzzle p) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.matrix[i][j] != p.matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int Kurang(int number) {
        // Mengembalikan nilai Kurang(number)
        int count = 0;
        int i = getIdxRow(number);
        int j = getIdxCol(i, number);
        j++;
        if (j == 4) {
            i++;
            j = 0;
        }
        while (i < 4) {
            while (j < 4) {
                if (number != 0) {
                    if (this.matrix[i][j] < number && this.matrix[i][j] != 0) {
                        count++;
                    }
                } else {
                    count++;
                }
                j++;
            }
            i++;
            if (i != 4) {
                j = 0;
            }
        }
        return count;
    }

    public int getX() {
        // Mengembalika nilai X pada puzzle
        int i = getIdxRow(0);
        int j = getIdxCol(i, 0);
        if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
            return 1;
        } else {
            return 0;
        }
    }

    public int calculateCost() {
        // Mengembalikan cost dari puzzle
        int cost = 0;
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                k++;
                if (this.matrix[i][j] != k && this.matrix[i][j] != 0) {
                    cost++;
                }
            }
        }
        return cost;
    }

    public boolean isSolution() {
        // Mengembalikan true apabila puzzle merupakan solusi
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                k++;
                if (this.matrix[i][j]  != k % 16) {
                    return false;
                }
            }
        }
        return true;
    }

    public Puzzle Up() {
        // Membuat simpul baru dengan menggeser puzzle ke atas
        int x = getIdxRow(0);
        int y = getIdxCol(x, 0);
        Puzzle result = new Puzzle(this);
        int temp = result.matrix[x][y];
        result.matrix[x][y] = result.matrix[x - 1][y];
        result.matrix[x - 1][y] = temp;
        result.cost = result.calculateCost();
        result.parrent = this;
        return result;
    }

    public Puzzle Down() {
        // Membuat simpul baru dengan menggeser puzzle ke bawah
        int x = getIdxRow(0);
        int y = getIdxCol(x, 0);
        Puzzle result = new Puzzle(this);
        int temp = result.matrix[x][y];
        result.matrix[x][y] = result.matrix[x + 1][y];
        result.matrix[x + 1][y] = temp;
        result.cost = result.calculateCost();
        result.parrent = this; 
        return result;
    }

    public Puzzle Left() {
        // Membuat simpul baru dengan menggeser puzzle ke kiri
        int x = getIdxRow(0);
        int y = getIdxCol(x, 0);
        Puzzle result = new Puzzle(this);
        int temp = result.matrix[x][y];
        result.matrix[x][y] = result.matrix[x][y - 1];
        result.matrix[x][y - 1] = temp;
        result.cost = result.calculateCost();
        result.parrent = this;
        return result;
    }

    public Puzzle Right() {
        // Membuat simpul baru dengan menggeser puzzle ke kanan
        int x = getIdxRow(0);
        int y = getIdxCol(x, 0);
        Puzzle result = new Puzzle(this);
        int temp = result.matrix[x][y];
        result.matrix[x][y] = result.matrix[x][y + 1];
        result.matrix[x][y + 1] = temp;
        result.cost = result.calculateCost();
        result.parrent = this;
        return result;
    }
}