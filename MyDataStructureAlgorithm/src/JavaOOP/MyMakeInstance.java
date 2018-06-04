package JavaOOP;

class Car {
	int gear; // 기어 변수 생성

	void gear() { // 기어 메서드 생성
	}
}

public class MyMakeInstance {
	public static void main(String args[]) {
		Car c; // Car인스턴스를 참조하기 위한 변수 c를 생성 이 상태에서 참조변수로 아무것도 할 수 없다.
		c = new Car(); // Car인스턴스를 생성한다. new 에 의해 Car클래스의 인스턴스가 메모리의 빈 공간에 생성된다.
		c.gear = 1; // Car인스턴스의 변수 gear를 1로 한다.
		c.gear(); // Car인스턴스의 메서드 gear()를 호출한다.
		System.out.println("기어를" + c.gear + "단으로 변경합니다.");
		System.out.println();
		
		Car arrCar[] = new Car[6]; //객체 배열의 활용
		for (int i = 1; i <=5; i++) {
			arrCar[i] = new Car();
			arrCar[i].gear = i;
			arrCar[i].gear();
			System.out.println("기어를" + arrCar[i].gear + "단으로 변경합니다.");
		}
		
	}
}
