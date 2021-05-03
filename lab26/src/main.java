public class main {
    public static void main(String[] args) {
        String test = "Санкт-Петербургский политехнический университет Петра Великого";
        System.out.println(createAbbreviation(test));
    }

    public static String createAbbreviation(String text) {
        char[] subStr = text.toCharArray();
        StringBuilder returningText = new StringBuilder();
        boolean addCharFlag = false;

        for (char c: subStr) {
            if (addCharFlag || c == text.charAt(0)) {
                returningText.append(c);
                addCharFlag = false;
            }

            if (Character.isSpaceChar(c) || c == '-') {
                addCharFlag = true;
            }
        }
        return returningText.toString().toUpperCase();
    }
}
