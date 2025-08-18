package mylab.book.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
    private List<Publication> items; // 장바구니에 담긴 출판물들을 관리

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true; // 성공적으로 제거됨
            }
        }
        System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
        return false; // 제거 실패
    }

    public void displayCart() {
        System.out.println("====== 장바구니 내용 ======");
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        DecimalFormat df = new DecimalFormat("#,###");
        for (int i = 0; i < items.size(); i++) {
            Publication item = items.get(i);
            System.out.println((i + 1) + ". " + item.getTitle() + " - " + df.format(item.getPrice()) + "원");
        }
        System.out.println("총 가격: " + df.format(calculateTotalPrice()) + "원");
        System.out.println("할인 적용 가격: " + df.format(calculateDiscountedPrice()) + "원");
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            // ManageBook과는 다른 할인율 적용 (용도별 차별화)
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9; // 10% 할인
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; // 15% 할인
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8; // 20% 할인
            } else {
                total += item.getPrice(); // 기본 출판물은 할인 없음
            }
        }
        return total;
    }

    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;
        // instanceof를 활용한 타입별 카운팅
        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }
        // 결과 출력
        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + magazineCount + "권");
        System.out.println("소설: " + novelCount + "권");
        System.out.println("참고서: " + referenceBookCount + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }

    public static void main(String[] args) {
        // 테스트용 출판물 데이터
        Publication[] publications = {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학")
        };

        ShoppingCart cart = new ShoppingCart();

        // 1. 장바구니에 아이템 추가
        cart.addItem(publications[0]);
        cart.addItem(publications[1]);
        cart.addItem(publications[2]);
        cart.addItem(publications[3]);
        cart.addItem(publications[4]);

        // 2. 장바구니 내용 및 통계 출력
        cart.displayCart();
        cart.printStatistics();

        // 3. '빠삐용' 제거
        System.out.println(); // 줄바꿈
        cart.removeItem("빠삐용");
        
        // 4. 변경된 장바구니 내용 출력
        cart.displayCart();
    }
}
