public class Main {
    public static void main(String[] args) {
       /* Dolgozo dolgozo = new Dolgozo("Józsi","kőműves",47000);
        Fonok fonok = new Fonok("Attila","cégvezető", 1500000,300000);
        System.out.println(dolgozo);
        System.out.println(fonok);
        System.out.println(fonok.evesFizetes());*/

        /*Pont2D p = new Pont2D(3,4);
        Pont2D q = new Pont2D();
        System.out.println(p.tavolsag());
        System.out.println(p.tavolsag(q));
        System.out.println(p);
        System.out.println(q);

        Line2D l = new Line2D(0,0,3,4);
        Line2D l1 = new Line2D(new Pont2D(),new Pont2D(3,4));
        Line2D l2 = new Line2D(p,q);

        System.out.println(l);
        System.out.println(l1);
        System.out.println(l2);*/

        /*LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++){
            linkedList.add(i*i);
            System.out.println(linkedList);
            System.out.println(linkedList.listBackwards());
        }*/

        Diak<Double> diak = new Diak<Double>("Józsi","10D",3.5);
        System.out.println(diak);
    }
}
