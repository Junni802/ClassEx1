package com.example.classex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		var rectTest = RectTest(10, 4)
		Log.d("classEx1", "${rectTest.round()}")
		Log.d("classEx1", "${rectTest.area()}")

		var rectTest1 = RectTest(30, 40)
		Log.d("classEx1", "${rectTest1.round()}")
		Log.d("classEx1", "${rectTest1.area()}")

		// 인스턴스 rectTest1에 들어있는 toString 함수가 자동으로 호출됨
		Log.d("classEx1", "${rectTest1}")

		objTest.printName()
		objTest.name = "전우치"
		objTest.printName()
		OCTest.test2()
		var find = OCTest()
		find.test1()
		find.test3()

		var info = MemberInfo("박준혁", "test1", "9376174", 500);
		Log.d("dataClass", "${info}")
		// data class의 인스턴스를 출력하면 내부 멤버변수와 값들을 보여줌
		// MemberInfo(name, id=test, pw=1234, pnt=1000)
		info.name = "전우치"
		info.password = "1234"
		info.point = 1000
		Log.d("dataClass", "${info}")
		Log.d("dataClass", "${info.name}")
		Log.d("dataClass", "${info.password}")
		Log.d("dataClass", "${info.point}")

		var mi2 = info.copy();
		Log.d("dataClass1", "${mi2}")

	}

}

// 너비와 높이를 저장할 멤버변수를 가지고, 사각형의 둘레와 넓이를 구하여 기천하는 함수를 가진 RectTest 클래스 제작

// 너비를 30으로 높이를 40으로 변경후 가격형의 넙이와 둘레 출력

class RectTest(width : Int, height : Int){
	var rkfh = width
	var tpfh = height
	fun round() : Int{
		return (rkfh * 2) + (tpfh * 2)
	}

	fun area() : Int{
		return rkfh * tpfh
	}
}

object objTest {
	var name = "박준혁"
	fun printName(){
		Log.d("objTest", "이름 : ${name}")
	}
}

class OCTest {
	fun test1(){ Log.d("OCTest", "test1() 실행") }
	companion object {
		var chk = "블록 내부의 변수"
		fun test2() { Log.d("OCTest", "test2() 실행, chk : ${chk}") }
	}
	fun test3() { Log.d("OCTest", "test3() 실행") }
}

// 이름 아이디, 암호, 포인트를 저장할 수 있는 회원정보 클래스 MemberInfo 작성

data class MemberInfo(var name : String, val id : String, var password : String, var point : Int)
// name과 id는 val로 선언하여 데이터 변경을 못하게 하고, pw와 pnt는 var로 선언하여 변경이 가능