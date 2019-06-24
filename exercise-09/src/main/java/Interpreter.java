public interface Interpreter {

    static boolean isGreater(String keyToInsert, String keyInTree){
        if(keyToInsert.compareToIgnoreCase(keyInTree) > 0){
            return true;
        } else {
            return false;
        }
    }

}
