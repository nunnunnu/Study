public class Ex9_1{
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);

        System.out.println("c1 = "+c1);
        System.out.println("c2 = "+c2);
        System.out.println("c1.equals(c2) : "+c1.equals(c2));
    }
}

class SutdaCard{
    int num;
    boolean isKwang;

    public SutdaCard(){
        this(1,true);
    }

    public SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public boolean equals(Object obj){
        if(obj instanceof SutdaCard){
            SutdaCard c = (SutdaCard)obj;
            return this.num==c.num && this.isKwang == c.isKwang;
        }else{
            return false;
        }
    }

    public String toString(){
        return num+(isKwang?"K":"");
    }

}