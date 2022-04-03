import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // KAMUS
        Scanner input = new Scanner(System.in);
        int sum_Kurang = 0;
        int i, x, y;
        Puzzle p = new Puzzle();
        Puzzle process;
        PrioPuzzle QPuzzle, checkPuzzle;
        long startTime, stopTime;
        long exeTime = 0;

        // ALGORITMA
        System.out.println("--------------------------------");
        System.out.println("           15-Puzzle            ");
        System.out.println("              With              ");
        System.out.println("    Branch & Bound Algorithm    ");
        System.out.println("   (With Heuristic Technique)   ");
        System.out.println("--------------------------------");
        System.out.println("            Made By             ");
        System.out.println("      13520160 Willy Wilsen     ");
        System.out.println("--------------------------------");

        // Input file
        System.out.print("Input your 15-Puzzle filename (.txt): ");
        String namafile = input.next();
        p.bacaFile(namafile);

        // Output puzzle awal
        System.out.println();
        System.out.println("Puzzle awal yang terbentuk:");
        p.output();

        // Output Kurang(i)
        System.out.println();
        System.out.println("Nilai untuk setiap Kurang(i):");
        for (i = 0; i < 16; i++) {
            System.out.println("Kurang(" + (i + 1) + ") = " + p.Kurang((i + 1) % 16));
            sum_Kurang += p.Kurang((i + 1) % 16);
        }

        // Output jumlah total Kurang(i) + X
        System.out.println();
        System.out.println("Jumlah total Kurang(i) + X adalah " + (sum_Kurang + p.getX()));

        // Output pesan
        System.out.println();
        if ((sum_Kurang + p.getX()) % 2 != 0) {
            System.out.println("15-Puzzle tidak dapat diselesaikan");
        } else {
            // Inisialisi variabel yang dibutuhkan
            QPuzzle = new PrioPuzzle(p);
            checkPuzzle = new PrioPuzzle(p);
            process = QPuzzle.puzzle[0];
            System.out.println("Simpul " + process.getSimpul());
            System.out.println();
            process.output();

            // Proses tiap langkah pergeseran puzzle
            while (!process.isSolution()) {
                startTime = System.nanoTime();
                x = process.getIdxRow(0);
                y = process.getIdxCol(x, 0);
                if (x == 0) {
                    if (y == 0) {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Right(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Down(), checkPuzzle);  
                    } else if (y == 3) {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Down(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Left(), checkPuzzle);
                    } else {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Right(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Down(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Left(), checkPuzzle); 
                    }
                } else if (x == 3) {
                    if (y == 0) {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Up(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Right(), checkPuzzle); 
                    } else if (y == 3) {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Up(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Left(), checkPuzzle); 
                    } else {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Up(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Right(), checkPuzzle); 
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Left(), checkPuzzle); 
                    }
                } else {
                    if (y == 0) {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Up(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Right(), checkPuzzle); 
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Down(), checkPuzzle); 
                    } else if (y == 3) {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Up(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Down(), checkPuzzle); 
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Left(), checkPuzzle); 
                    } else {
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Up(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Right(), checkPuzzle);
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Down(), checkPuzzle); 
                        QPuzzle.enqueue(QPuzzle.puzzle[0].Left(), checkPuzzle); 
                    }
                }
                process = QPuzzle.dequeue();
                process = QPuzzle.puzzle[0];
                stopTime = System.nanoTime();
                exeTime += (stopTime - startTime)/1000000;
                System.out.println();
                System.out.println("Simpul " + process.getSimpul());
                System.out.println();
                process.output();
            }
            
            // Output total simpul dan waktu eksekusi program
            System.out.println();
            System.out.println("Execution Time: " + exeTime + " ms");
            System.out.println("Total simpul yang terbentuk adalah sebanyak " + p.getAllSimpul() + " simpul");
            System.out.println();
        }
    }
}
