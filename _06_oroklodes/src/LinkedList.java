import java.util.List;

public class LinkedList {
    private class ListItem{
        public int adat;
        public ListItem kovetkezo;
        public ListItem elozo;

        public ListItem(int adat){
            this.adat = adat;
            this.kovetkezo = null;
            this.elozo = null;
        }
    }

    private ListItem head;
    private ListItem tail;
    private int count;

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public int getCount() {return count;}

    public void add(int adat){
        if(count==0){
            //üres a lista
            head = tail = new ListItem(adat);
        }else{
            ListItem newItem = new ListItem(adat);
            tail.kovetkezo = newItem;
            newItem.elozo = tail;
            tail = newItem;
        }
        count++;
    }

    /**@param n-edik elem értékét adja vissza*/
    public int valueAt(int n){
        int w = 0;
        ListItem temp = head;
        while(w < n){
            w++;
            temp = temp.kovetkezo;
        }
        return temp.adat;
    }

    /*public void print(){
        ListItem current = head;
        while(current != null){
            System.out.println(current.adat);
            current = current.kovetkezo;
        }
    }*/

    public String listBackwards(){
        String txt = "";
        ListItem current = tail;
        while(current != null){
            txt += current.adat + " -> ";
            current = current.elozo;
        }
        return "[" + txt.substring(0,txt.length()-4) + "]";
    }

    @Override
    public String toString() {
        String txt = "";
        ListItem current = head;
        while(current != null){
            txt += current.adat + " -> ";
            current = current.kovetkezo;
        }
        return "[" + txt.substring(0,txt.length()-4) + "]";
    }
}
