package com.maeun.daycounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
//
        val calendar = Calendar.getInstance()
//        val weekDay = dayFormat.format(calendar.time)
//
//        Toast.makeText(this, weekDay, Toast.LENGTH_SHORT).show()


        val formatter = SimpleDateFormat("yyyyMMdd")

//        var date = formatter.parse("20190721")  // 날짜 입력하는곳 .
//
//        val cal = Calendar.getInstance()
//        cal.time = date              // 하루더한 날자 값을 Calendar  넣는다.
//
//        val dayNum = cal.get(Calendar.DAY_OF_WEEK)   // 요일을 구해온다.
//
//        var convertedString = ""
//
//        when (dayNum) {
//            1 -> convertedString = "일요일"
//            2 -> convertedString = "월요일"
//            3 -> convertedString = "화요일"
//            4 -> convertedString = "수요일"
//            5 -> convertedString = "목요일"
//            6 -> convertedString = "금요일"
//            7 -> convertedString = "토요일"
//        }
//
//        Toast.makeText(this, convertedString, Toast.LENGTH_SHORT).show()





        val instance = Calendar.getInstance()
        val year = instance.get(Calendar.YEAR)
        val month = instance.get(Calendar.MONTH)+1
        val date = instance.get(Calendar.DATE)






//        val d_day = 21 - Integer.parseInt(date)
//        val tz = TimeZone.getTimeZone("Asia/Seoul")
//        val gc = GregorianCalendar(tz)
//        var year = gc.get(GregorianCalendar.YEAR)
//        var month = gc.get(GregorianCalendar.MONTH)+1
//        var day = gc.get(GregorianCalendar.DATE)













        var day21 = ""
//
//        Toast.makeText(this, date.toString(), Toast.LENGTH_SHORT)
//        WorkingWeekDays.setText((21-date).toString())
//
//        payday.setText(year.toString()+"년 "+month.toString()+"월 "+date.toString()+"일")













        //21일 요일 구하기
        if(month <= 9){
            day21 = year.toString()+"0"+month.toString()+"21"
        }

        val cal = Calendar.getInstance()
        cal.time = formatter.parse(day21) //cal의 time이라는 인자에 yyyyMM21이라는 날짜를 넣음

        val dayNum = cal.get(Calendar.DAY_OF_WEEK)   // 요일을 구해온다.

//        dayNum
//            1 -> convertedString = "일요일"
//            2 -> convertedString = "월요일"
//            3 -> convertedString = "화요일"
//            4 -> convertedString = "수요일"
//            5 -> convertedString = "목요일"
//            6 -> convertedString = "금요일"
//            7 -> convertedString = "토요일"

        //21일이 토요일이면 하루 전 (물론 아직은 공휴일에 대한 계산과 영업일에 대한 개념은 없음)

//        Toast.makeText(this, dayNum.toString(), Toast.LENGTH_SHORT).show()

        if(dayNum == 1){
            payday.setText(year.toString()+month.toString()+(21-2).toString())
            paydayDday.setText((21-2-date).toString())
            Toast.makeText(this, dayNum.toString(), Toast.LENGTH_SHORT).show()
        }
        //21일이 일요일이면 이틀 전 (물론 아직은 공휴일에 대한 계산과 영업일에 대한 개념은 없음)
        else if(dayNum == 7){
            payday.setText(year.toString()+month.toString()+(21-1).toString())
            paydayDday.setText((21-1-date).toString())
            Toast.makeText(this, dayNum.toString(), Toast.LENGTH_SHORT).show()
        }
        else{
            paydayDday.setText((21-date).toString())
            Toast.makeText(this, dayNum.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}