package hello.core.singleton;

public class StatefulService {
    //private int price;

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;// price를 바로 get하는 방식으로 수정
    }

//    public int getPrice() {
//        return price;
//    }
}
