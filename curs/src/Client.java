import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        //Подключаемся к сервер сокету по адресу 4004
        try (Socket socket = new Socket("localhost", 4004)) {
            //Определеяем чтение с консоли и чтение и запись в сокет
            try (BufferedReader textReader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                while (true) {
                    System.out.println("Введите сообщение дла Алисы");
                    //Считываем текст с консоли
                    String sentence = textReader.readLine();
                    //Записываем текст в сокет
                    socketWriter.write(sentence + "\n");
                    //Выталкиваем сокет на сервер
                    socketWriter.flush();
                    //Считываем текст от сервера
                    String messageFromAlisa = socketReader.readLine();
                    System.out.println(messageFromAlisa);
                    if (sentence.equals("close"))
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
