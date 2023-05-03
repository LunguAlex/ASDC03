import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {

    // Путь к файлу
    private static final String FILE_PATH = "src/list.txt";

    // Метод для чтения содержимого файла в стек
    public static Stack<String> readFile() {
        Stack<String> stack = new Stack<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                stack.push(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stack;
    }

    // Метод для записи содержимого стека в файл
    public static void writeFile(Stack<String> stack) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (String line : stack) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для обхода и вывода содержимого стека
    public static void traverseStack(Stack<String> stack) {
        for (String line : stack) {
            System.out.println(line);
        }
    }

    // Метод для вставки элемента в стек
    public static void pushToStack(Stack<String> stack, String line) {
        stack.push(line);
        writeFile(stack);
    }

    // Метод для поиска элемента в стеке
    public static void searchInStack(Stack<String> stack, String query) {
        boolean found = false;

        for (String line : stack) {
            if (line.contains(query)) {
                System.out.println(line);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Элемент не найден");
        }
    }

    // Метод для удаления элемента из стека
    public static void removeFromStack(Stack<String> stack, String query) {
        boolean removed = false;

        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).contains(query)) {
                stack.remove(i);
                writeFile(stack);
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Элемент не найден");
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = readFile();
        traverseStack(stack);
        pushToStack(stack, "Г,А,В,1999,2017,654321");
        searchInStack(stack, "Математический");
        removeFromStack(stack, "Иван");
    }
}