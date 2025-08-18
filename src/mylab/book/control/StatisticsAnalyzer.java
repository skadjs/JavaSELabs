package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> priceSum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            priceSum.put(type, priceSum.getOrDefault(type, 0) + pub.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averagePrice = new HashMap<>();
        for (String type : priceSum.keySet()) {
            averagePrice.put(type, (double) priceSum.get(type) / count.get(type));
        }
        return averagePrice;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> count = new HashMap<>();
        int total = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : count.keySet()) {
            distribution.put(type, (double) count.get(type) * 100 / total);
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count * 100 / publications.length;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###");
        DecimalFormat pf = new DecimalFormat("0.00");

        System.out.println("\n===== 출판물 통계 분석 =====");

        // 1. 타입별 평균 가격 출력
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPriceMap = calculateAveragePriceByType(publications);
        for (Map.Entry<String, Double> entry : avgPriceMap.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + df.format(entry.getValue()) + "원");
        }

        // 2. 출판물 유형 분포 출력
        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distributionMap = calculatePublicationDistribution(publications);
        for (Map.Entry<String, Double> entry : distributionMap.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + pf.format(entry.getValue()) + "%");
        }

        // 3. 2007년에 출판된 출판물 비율 출력
        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + pf.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}
