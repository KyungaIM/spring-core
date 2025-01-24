package hello.core.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;// 싱글톤이라서 사용자와 관계없이 모두 같은 price에 저장함
    }

    public int getPrice() {
        return price;
    }
}
