import java.util.Scanner;

public class AplikasiTodoList {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
//        testViewRemoveTodoList();

        viewShowTodoList();

    }


    // Test
    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Aku Ganteng Banget";
        showTodoList();
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 20; i++) {
            addTodoList("Contoh Todo Ke - " + i);
        }
        showTodoList();
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("Tiga");

        var result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }
    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
    }
    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }
    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        viewAddTodoList();

        showTodoList();
    }
    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }


    // Business Logic
    // Menampilkan Todo List
    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    // Menambahkan Todo ke List
    public static void addTodoList(String todo) {
        // Cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // Jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            var temporary = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temporary.length; i++) {
                model[i] = temporary[i];
            }
        }


        // Tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    // Menghapus Todo dari List
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else { // Logic Menggeser
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length) - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }

            return true;
        }
    }

    // Input Data
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }


    // View // Tampilan
    // Menampilkan View Todo List
    public static void viewShowTodoList() {

        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")){
                break;
            } else {
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }

    }

    // Menampilkan View Menambahkan Todo List
    public static void viewAddTodoList() {
        System.out.println("Menambah Todo List");
        var todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }

    // Menampilkan View Menghapus TodoList
    public static void viewRemoveTodoList() {
        System.out.println("Menghapus Todo List");
        var number = input("Nomor Yang Dihapus (x jika batal)");

        if (number.equals("x")) {
            // Batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number)); // Konversi String to Integer
            if (!success) {
                System.out.println("Gagal Menghapus Todo List : " + number);
            }
        }
    }

}
