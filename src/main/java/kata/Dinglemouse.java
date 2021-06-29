package kata;

class Dinglemouse {

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

  public  String[] flapDisplay(final String[] lines, final int[][] rotors) {
    String[] result = new String[lines.length];
    for (int line = 0; line < lines.length; line++) {
      StringBuilder temp = new StringBuilder();
      for (int kar = 0; kar < lines[line].length(); kar++) {
        for (int asd = kar; asd < lines[line].length(); asd++) {
          System.out.println(ALPHABET.charAt((ALPHABET.indexOf(lines[line].charAt(asd)) + rotors[line][kar]) % ALPHABET.length()));
          //System.out.println(ALPHABET.charAt(rotors[line][kar]));
          temp.append(ALPHABET.charAt((ALPHABET.indexOf(lines[line].charAt(asd)) + rotors[line][kar]) % ALPHABET.length()));
        }
        result[line] = temp.toString();
      }
    }
    return result;
  }

}
