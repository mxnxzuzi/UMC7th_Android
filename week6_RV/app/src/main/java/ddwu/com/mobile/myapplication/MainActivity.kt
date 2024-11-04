package ddwu.com.mobile.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 더미 데이터
        val dummyData = listOf(
            RestaurantItem("김밥천국", "맛있는 김밥과 라면", "30분"),
            RestaurantItem("피자나라 치킨공주", "피자와 치킨 세트 할인", "45분"),
            RestaurantItem("홍콩반점", "짜장면, 짬뽕, 탕수육", "25분"),
            RestaurantItem("맘스터치", "바삭한 치킨버거", "20분"),
            RestaurantItem("곱창이야기", "신선한 곱창구이", "40분"),
            RestaurantItem("김밥천국", "맛있는 김밥과 라면", "30분"),
            RestaurantItem("피자나라 치킨공주", "피자와 치킨 세트 할인", "45분"),
            RestaurantItem("홍콩반점", "짜장면, 짬뽕, 탕수육", "25분"),
            RestaurantItem("맘스터치", "바삭한 치킨버거", "20분"),
            RestaurantItem("곱창이야기", "신선한 곱창구이", "40분"),
            RestaurantItem("김밥천국", "맛있는 김밥과 라면", "30분"),
            RestaurantItem("피자나라 치킨공주", "피자와 치킨 세트 할인", "45분"),
            RestaurantItem("홍콩반점", "짜장면, 짬뽕, 탕수육", "25분"),
            RestaurantItem("맘스터치", "바삭한 치킨버거", "20분"),
            RestaurantItem("곱창이야기", "신선한 곱창구이", "40분")

        )

        recyclerView.adapter = ItemAdapter(dummyData)
    }
}
