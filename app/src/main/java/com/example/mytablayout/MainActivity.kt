package com.example.mytablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

//  panggil kelas sectionpageradaptor lalu setup ViewPager2 dan TabLayout
class MainActivity : AppCompatActivity() {

    companion object{
        @StringRes
        private val TABB_FILES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)

        //  menghubungkan SectionsPagerAdapter dengan ViewPager2
        viewPager.adapter = sectionsPagerAdapter

        // menghubungkan ViewPager2 dengan TabLayout
        /*
        Dengan menerapkan TabLayoutMediator, maka Fragment yang tampil pada ViewPager2 akan sesuai
        dengan posisi yang dipilih pada tab. Selain itu, di sini Anda juga menentukan judul dari
        masing-masing Tab dengan menggunakan TAB_TITLE yang diambil sesuai dengan urutan posisinya
         */
        TabLayoutMediator(tabs,viewPager) {tab, position ->
            tab.text = resources.getString(TABB_FILES[position])
        }.attach()

        supportActionBar?.elevation = 0f



    }
}