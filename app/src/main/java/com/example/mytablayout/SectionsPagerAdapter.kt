package com.example.mytablayout

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// mengatur ViewPager2 dan TabLayout

/*
1. FragmentStateAdapter merupakan base adapter yang digunakan untuk mengatur data pada ViewPager2
2. constructor yang diperlukan yaitu AppCompatActivity karena kita menggunakan Activity
3. Apabila kita menerapkannya di Fragment, gunakan FragmentActivity
4. kita dapat menggunakan RecyclerView.Adapter sebagai adapter. Hal ini karena pada dasarnya ViewPager2 dibuat menggunakan RecyclerView
 */
class SectionsPagerAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity){

    /*
    Fungsi createFragment digunakan untuk menampilkan fragment sesuai dengan posisi tab-nya
     */
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            // klik/swipe -> move fragment
            0 -> fragment = HomeFragment()
            1 -> fragment = ProfileFragment()
        }
        return fragment as Fragment
    }

    /*
    Fungsi getItemCount digunakan untuk menentukan jumlah tab yang ingin ditampilkan
    Pastikan bahwa jumlah yang ditampilkan sesuai dengan Fragment yang didefinisikan oleh fungsi createFragment
    kalau ngga maka error
     */
    override fun getItemCount(): Int {
        return 2
    }

}