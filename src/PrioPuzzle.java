public class PrioPuzzle {
    // Atribut
    public Puzzle[] puzzle;

    /* CONSTRUCTOR */
    public PrioPuzzle(Puzzle p) {
        this.puzzle = new Puzzle[1];
        this.puzzle[0] = p;
    }

    // Method
    public void enqueue(Puzzle p, PrioPuzzle check) {
        // Apabila puzzle p tidak berada dalam prio puzzle check, menambah puzzle ke dalam prio puzzle this sesuai dengan urutan cost
        if (!check.isExist(p)) {
            Puzzle newPuzzle[] = new Puzzle[this.puzzle.length + 1];
            int i = this.puzzle.length;
            while (i > 0 && this.puzzle[i - 1].getCost() > p.getCost()) {
                newPuzzle[i] = this.puzzle[i - 1];
                i--;
            }
            newPuzzle[i] = p;
            i--;
            while (i >= 0) {
                newPuzzle[i] = this.puzzle[i];
                i--;
            }
            this.puzzle = newPuzzle;
        } else {
            p.kurangSimpul();
        }
    }

    public Puzzle dequeue() {
        // Menghapus prio puzzle elemen pertama
        Puzzle newPuzzle[] = new Puzzle[this.puzzle.length - 1];
        for (int i = 0; i < this.puzzle.length - 1; i++) {
            newPuzzle[i] = this.puzzle[i + 1];
        }
        Puzzle result = this.puzzle[0];
        this.puzzle = newPuzzle;
        return result;
    }

    public boolean isExist(Puzzle p) {
        // Mengembalikan true apabila puzzle p berada dalam prio puzzle
        for (int i = 0; i < this.puzzle.length; i++) {
            if (this.puzzle[i].isSame(p)) {
                return true;
            }
        }

        // Menambah puzzle p ke dalam elemen terakhir prio puzzle jika puzzle p sebelumnya tidak ada
        Puzzle newPuzzle[] = new Puzzle[this.puzzle.length + 1];
        for (int i = 0; i < this.puzzle.length; i++) {
            newPuzzle[i] = this.puzzle[i];
        }
        newPuzzle[this.puzzle.length] = p;
        this.puzzle = newPuzzle;
        return false;
    }
}