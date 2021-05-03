public class TextEditor {
    public static String randomWordGenerator(String sentence) {
        //Массив слов из предложения разделенного по пробелам
        String[] words = sentence.split(" ");
        //Получаем индекс случайного слова из массива слов
        int wordIndex = (int) (Math.random() * words.length);
        return words[wordIndex];
    }
}
