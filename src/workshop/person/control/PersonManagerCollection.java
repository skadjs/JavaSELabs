package workshop.person.control;

import workshop.person.entity.PersonEntity;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonManagerCollection {

	public static void main(String[] args) {
		
		//Scanner 사용
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("==> 성별을 입력하세요!"); //성별 입력 받기
		String inputValue = scanner.next();
		char gender = inputValue.charAt(0); //String -> char 변경
		
		System.out.println("==> 이름을 입력하세요!"); //이름 입력 받기
		String name = scanner.next();
		
		System.out.println(String.format("==> 입력하신 성별은 %s, 이름은 %s", gender, name) + "\n");
		
		//non-static 메서드 호출을 위한 객체 생성
		PersonManagerCollection personMgr = new PersonManagerCollection();
		
		//ArrayList 선언
		List<PersonEntity> personList = new ArrayList<>();
		personMgr.fillPersons(personList);
		
		//인물 정보 출력
		personMgr.printTitle("인물정보 조회시스템");
		personMgr.showPerson(personList);
				
		//특정 성별이 몇 명인지 찾기
		String message = String.format("성별 : %s (은)는 %d명입니다.", gender, personMgr.findByGender(personList, gender));
		System.out.println(message);
		
		//이름으로 사람 찾기 -> 결과(이름, 성별, 전화번호, 주소) 출력까지
		personMgr.showPerson(personList, name);
		
		scanner.close();
	}
	
	public void showPerson(List<PersonEntity> persons, String name) {
		for(PersonEntity person : persons) {
			if(person.getName().equals(name)) {
				System.out.println("[이름] " + person.getName());
				System.out.println("[성별] " + person.getGender());
				System.out.println("[전화번호] " + person.getPhone());
				System.out.println("[주소] " + person.getAddress());
				break;
			}
		}
	}
	
	public int findByGender(List<PersonEntity> persons, char gender) {
		int genderCnt = 0;
		for(PersonEntity person : persons) {
			if(person.getGender() == gender) {
				genderCnt++;
			}
		}
		return genderCnt;
	}

	//for문 순회하며 정보 출력
	public void showPerson(List<PersonEntity> persons) {
		for(PersonEntity person : persons) { // "\t" <- 탭을 의미함(띄어쓰기 네 번)
			System.out.println("[이름 ] " + person.getName() + "\t [성별] " + person.getGender() + "\t [전화번호] " + person.getPhone());
		}
	}

	public void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932"));
		persons.add(new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932"));
		persons.add(new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542"));
		persons.add(new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223"));
		persons.add(new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333"));
		persons.add(new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934"));
		persons.add(new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932"));
		persons.add(new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939"));
		persons.add(new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202"));
		persons.add(new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832"));
	}
		
	public void printTitle(String title) {
		System.out.println("@@@ " + title + " @@@");
		System.out.println();
	}
}