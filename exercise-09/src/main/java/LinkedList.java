public class LinkedList {

    Word head;
    int lengt;

    public LinkedList() {
        head = null;
        lengt =0;
    }

    public void insert(String word){
        if (head==null){
            head = new Word(null, null, word);
            lengt++;

        } else {
            Word lastWord = head;
            int i = 1;
            while(i!=lengt){
                lastWord = lastWord.next;
                i++;
            }
            lastWord.next = new Word(lastWord, null, word);
            lengt++;
        }
    }

    public int search(String word){
        int nodesTraversed = 1;
        Word lastWord = head;
        while(nodesTraversed!=lengt){
            lastWord = lastWord.next;
            nodesTraversed++;
            if(lastWord.word==word){
                return nodesTraversed;
            }
        }
        return 0;
    }


}
