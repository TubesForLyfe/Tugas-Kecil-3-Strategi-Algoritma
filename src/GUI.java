import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private static JLabel filenameLabel;
    private static JTextField filenameInput;
    private static JButton button;
    private static JLabel processLabel;
    private static JLabel authorLabel;
    private static JLabel timeLabel;
    private static JLabel simpulLabel;
    private static JLabel puzzle1;
    private static JLabel puzzle2;
    private static JLabel puzzle3;
    private static JLabel puzzle4;
    private static JLabel puzzle5;
    private static JLabel puzzle6;
    private static JLabel puzzle7;
    private static JLabel puzzle8;
    private static JLabel puzzle9;
    private static JLabel puzzle10;
    private static JLabel puzzle11;
    private static JLabel puzzle12;
    private static JLabel puzzle13;
    private static JLabel puzzle14;
    private static JLabel puzzle15;
    private static JLabel puzzle16;
    private static int x;
    private static int y;
    private static PrioPuzzle QPuzzle;
    private static PrioPuzzle checkPuzzle;
    private static Puzzle process;
    private static long exeTime;

    public static void main(String[] args) {
        // Inisialisasi GUI
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("15-Puzzle Game");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setBackground(new Color(185,156,107));

        panel.setLayout(null);

        filenameLabel = new JLabel("Input your 15-Puzzle filename (.txt)");
        filenameLabel.setBounds(10, 20, 200, 25);
        panel.add(filenameLabel);

        filenameInput = new JTextField(20);
        filenameInput.setBounds(225, 20, 165, 25);
        panel.add(filenameInput);

        button = new JButton("Enter");
        button.setBounds(400, 20, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        processLabel = new JLabel("Solution Puzzle");
        processLabel.setBounds(100, 50, 400, 50);
        panel.add(processLabel);

        authorLabel = new JLabel("13520160 Willy Wilsen");
        authorLabel.setBounds(200, 300, 400, 50);
        panel.add(authorLabel);

        timeLabel = new JLabel("");
        timeLabel.setBounds(250, 100, 400, 50);
        panel.add(timeLabel);

        simpulLabel = new JLabel("");
        simpulLabel.setBounds(250, 125, 400, 50);
        panel.add(simpulLabel);

        // Label for 15-Puzzle
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);

        puzzle1 = new JLabel("  1");
        puzzle1.setBounds(125, 100, 25, 25);
        puzzle1.setBorder(lineBorder);
        puzzle1.setBackground(new Color(211,211,211));
        puzzle1.setOpaque(true);
        panel.add(puzzle1);

        puzzle2 = new JLabel("  2");
        puzzle2.setBounds(150, 100, 25, 25);
        puzzle2.setBorder(lineBorder);
        puzzle2.setBackground(new Color(211,211,211));
        puzzle2.setOpaque(true);
        panel.add(puzzle2);

        puzzle3 = new JLabel("  3");
        puzzle3.setBounds(175, 100, 25, 25);
        puzzle3.setBorder(lineBorder);
        puzzle3.setBackground(new Color(211,211,211));
        puzzle3.setOpaque(true);
        panel.add(puzzle3);

        puzzle4 = new JLabel("  4");
        puzzle4.setBounds(200, 100, 25, 25);
        puzzle4.setBorder(lineBorder);
        puzzle4.setBackground(new Color(211,211,211));
        puzzle4.setOpaque(true);
        panel.add(puzzle4);

        puzzle5 = new JLabel("  5");
        puzzle5.setBounds(125, 125, 25, 25);
        puzzle5.setBorder(lineBorder);
        puzzle5.setBackground(new Color(211,211,211));
        puzzle5.setOpaque(true);
        panel.add(puzzle5);

        puzzle6 = new JLabel("  6");
        puzzle6.setBounds(150, 125, 25, 25);
        puzzle6.setBorder(lineBorder);
        puzzle6.setBackground(new Color(211,211,211));
        puzzle6.setOpaque(true);
        panel.add(puzzle6);

        puzzle7 = new JLabel("  7");
        puzzle7.setBounds(175, 125, 25, 25);
        puzzle7.setBorder(lineBorder);
        puzzle7.setBackground(new Color(211,211,211));
        puzzle7.setOpaque(true);
        panel.add(puzzle7);

        puzzle8 = new JLabel("  8");
        puzzle8.setBounds(200, 125, 25, 25);
        puzzle8.setBorder(lineBorder);
        puzzle8.setBackground(new Color(211,211,211));
        puzzle8.setOpaque(true);
        panel.add(puzzle8);

        puzzle9 = new JLabel("  9");
        puzzle9.setBounds(125, 150, 25, 25);
        puzzle9.setBorder(lineBorder);
        puzzle9.setBackground(new Color(211,211,211));
        puzzle9.setOpaque(true);
        panel.add(puzzle9);

        puzzle10 = new JLabel(" 10");
        puzzle10.setBounds(150, 150, 25, 25);
        puzzle10.setBorder(lineBorder);
        puzzle10.setBackground(new Color(211,211,211));
        puzzle10.setOpaque(true);
        panel.add(puzzle10);

        puzzle11 = new JLabel(" 11");
        puzzle11.setBounds(175, 150, 25, 25);
        puzzle11.setBorder(lineBorder);
        puzzle11.setBackground(new Color(211,211,211));
        puzzle11.setOpaque(true);
        panel.add(puzzle11);

        puzzle12 = new JLabel(" 12");
        puzzle12.setBounds(200, 150, 25, 25);
        puzzle12.setBorder(lineBorder);
        puzzle12.setBackground(new Color(211,211,211));
        puzzle12.setOpaque(true);
        panel.add(puzzle12);

        puzzle13 = new JLabel(" 13");
        puzzle13.setBounds(125, 175, 25, 25);
        puzzle13.setBorder(lineBorder);
        puzzle13.setBackground(new Color(211,211,211));
        puzzle13.setOpaque(true);
        panel.add(puzzle13);

        puzzle14 = new JLabel(" 14");
        puzzle14.setBounds(150, 175, 25, 25);
        puzzle14.setBorder(lineBorder);
        puzzle14.setBackground(new Color(211,211,211));
        puzzle14.setOpaque(true);
        panel.add(puzzle14);

        puzzle15 = new JLabel(" 15");
        puzzle15.setBounds(175, 175, 25, 25);
        puzzle15.setBorder(lineBorder);
        puzzle15.setBackground(new Color(211,211,211));
        puzzle15.setOpaque(true);
        panel.add(puzzle15);

        puzzle16 = new JLabel("");
        puzzle16.setBounds(200, 175, 25, 25);
        puzzle16.setBorder(lineBorder);
        puzzle16.setBackground(new Color(211,211,211));
        puzzle16.setOpaque(true);
        panel.add(puzzle16);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int sum_Kurang = 0;
        int i;
        Puzzle p = new Puzzle();
        p.bacaFile(filenameInput.getText());
        filenameInput.setText("");
        for (i = 0; i < 16; i++) {
            sum_Kurang += p.Kurang((i + 1) % 16);
        }

        if ((sum_Kurang + p.getX()) % 2 != 0) {
            processLabel.setText("Warning: 15-Puzzle cannot be solved");
            GUI.setNumber(p);
            processLabel.setForeground(Color.RED);
            p.resetSimpul();
        } else {
            // Inisialisasi variabel yang dibutuhkan
            QPuzzle = new PrioPuzzle(p);
            checkPuzzle = new PrioPuzzle(p);
            List<Puzzle> result = new ArrayList<>();
            Timer timer = new Timer();
            int time = 1200;
            processLabel.setForeground(Color.BLACK);
            processLabel.setText("Solution Puzzle");
            timeLabel.setText("");
            simpulLabel.setText("");
            process = QPuzzle.puzzle[0];
            long startTime, stopTime;
            exeTime = 0;

            // Proses tiap langkah pergeseran puzzle
            while (!process.isSolution()) {
                process = QPuzzle.dequeue();
                if (process.isSolution()) {
                    break;
                }
                x = process.getIdxRow(0);
                y = process.getIdxCol(x, 0);
                startTime = System.nanoTime();
                if (x == 0) {
                    if (y == 0) {
                        QPuzzle.enqueue(process.Right(), checkPuzzle);
                        QPuzzle.enqueue(process.Down(), checkPuzzle);  
                    } else if (y == 3) {
                        QPuzzle.enqueue(process.Down(), checkPuzzle);
                        QPuzzle.enqueue(process.Left(), checkPuzzle);
                    } else {
                        QPuzzle.enqueue(process.Right(), checkPuzzle);
                        QPuzzle.enqueue(process.Down(), checkPuzzle);
                        QPuzzle.enqueue(process.Left(), checkPuzzle); 
                    }
                } else if (x == 3) {
                    if (y == 0) {
                        QPuzzle.enqueue(process.Up(), checkPuzzle);
                        QPuzzle.enqueue(process.Right(), checkPuzzle); 
                    } else if (y == 3) {
                        QPuzzle.enqueue(process.Up(), checkPuzzle);
                        QPuzzle.enqueue(process.Left(), checkPuzzle); 
                    } else {
                        QPuzzle.enqueue(process.Up(), checkPuzzle);
                        QPuzzle.enqueue(process.Right(), checkPuzzle); 
                        QPuzzle.enqueue(process.Left(), checkPuzzle); 
                    }
                } else {
                    if (y == 0) {
                        QPuzzle.enqueue(process.Up(), checkPuzzle);
                        QPuzzle.enqueue(process.Right(), checkPuzzle); 
                        QPuzzle.enqueue(process.Down(), checkPuzzle); 
                    } else if (y == 3) {
                        QPuzzle.enqueue(process.Up(), checkPuzzle);
                        QPuzzle.enqueue(process.Down(), checkPuzzle); 
                        QPuzzle.enqueue(process.Left(), checkPuzzle); 
                    } else {
                        QPuzzle.enqueue(process.Up(), checkPuzzle);
                        QPuzzle.enqueue(process.Right(), checkPuzzle);
                        QPuzzle.enqueue(process.Down(), checkPuzzle); 
                        QPuzzle.enqueue(process.Left(), checkPuzzle); 
                    }
                }
                stopTime = System.nanoTime();
                exeTime += (stopTime - startTime)/1000000;
            }
            
            // Memasukkan urutan puzzle solusi ke dalam process
            while (process != null) {
                result.add(0, process);
                process = process.getParrent();
            }

            // Mengeluarkan urutan puzzle solusi ke layar
            for (Puzzle allresult : result) {
                TimerTask task = new TimerTask() {
                    public void run() {
                        processLabel.setText("Processing: Simpul " + allresult.getSimpul());
                        GUI.setNumber(allresult);
                        if (allresult.isSolution()) {
                            timer.cancel();
                            processLabel.setForeground(Color.GREEN);
                            processLabel.setText("Solution: Simpul " + allresult.getSimpul());
                            timeLabel.setText("Execution Time: " + exeTime + " ms");
                            simpulLabel.setText("Total simpul: " + allresult.getAllSimpul() + " simpul");
                            allresult.resetSimpul();
                        }
                    }
                };
                timer.schedule(task, time);
                time += 1000;
            }
        }
    }

    public static String convertToString(int number) {
        // Mengubah integer menjadi string dalam label
        if (number == 0) {
            return "  ";
        } else {
            String result = " ";
            if (number < 10) {
                result += " ";
            }
            result += Integer.toString(number);
            return result;
        }
    }

    public static void setNumber(Puzzle p) {
        // Mengubah label puzzle
        puzzle1.setText(convertToString(p.matrix[0][0]));
        puzzle2.setText(convertToString(p.matrix[0][1]));
        puzzle3.setText(convertToString(p.matrix[0][2]));
        puzzle4.setText(convertToString(p.matrix[0][3]));
        puzzle5.setText(convertToString(p.matrix[1][0]));
        puzzle6.setText(convertToString(p.matrix[1][1]));
        puzzle7.setText(convertToString(p.matrix[1][2]));
        puzzle8.setText(convertToString(p.matrix[1][3]));
        puzzle9.setText(convertToString(p.matrix[2][0]));
        puzzle10.setText(convertToString(p.matrix[2][1]));
        puzzle11.setText(convertToString(p.matrix[2][2]));
        puzzle12.setText(convertToString(p.matrix[2][3]));
        puzzle13.setText(convertToString(p.matrix[3][0]));
        puzzle14.setText(convertToString(p.matrix[3][1]));
        puzzle15.setText(convertToString(p.matrix[3][2]));
        puzzle16.setText(convertToString(p.matrix[3][3]));
    }
}
