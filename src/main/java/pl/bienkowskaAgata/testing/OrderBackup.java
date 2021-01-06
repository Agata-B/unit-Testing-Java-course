package pl.bienkowskaAgata.testing;

import org.mockito.internal.matchers.Or;

import java.io.*;

public class OrderBackup {

    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

    void createFile () throws FileNotFoundException {
        File file = new File("orderBackUp.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
    }

    void backUpOrder(Order order) throws IOException {
        writer.append(order.toString());
    }
    void closeFile () throws IOException {
        writer.close();
    }
}

