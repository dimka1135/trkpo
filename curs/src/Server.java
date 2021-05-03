import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //Ставим сервер на 4004 порт
        try (ServerSocket server = new ServerSocket(4004)) {
            System.out.println("Алиса ждёт пользователя");
            //Прослущиваем клиента
            try (Socket clientSocket = server.accept()) {
                //Когда клиент найден определяем чтение и запись из сокета нашего клиента
                try (BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                    while (true) {
                        //Считываем текст пользователя
                        String sentence = socketReader.readLine();
                        //Записываем случайное слово из предложения пользователя в сокет
                        socketWriter.write(TextEditor.randomWordGenerator(sentence) + "?\n");
                        //Выталкиваем наш текст обратно клиенту
                        socketWriter.flush();

                        if (sentence.equals("close"))
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
