package com.example.shoplyecommerceapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class HomeFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var tabLayout: TabLayout
    private val slideDelay: Long = 3000


    val categories = listOf(
        CategoryDataModel("Fashion", R.drawable.apparel_24px, R.color.lightlavender, R.color.lavender),
        CategoryDataModel("Electronics", R.drawable.computer_24px, R.color.lilghtred, R.color.red),
        CategoryDataModel("Appliances", R.drawable.kitchen_24px, R.color.lightgreen, R.color.green),
        CategoryDataModel("Beauty", R.drawable.lipstick, R.color.lightblue, R.color.blue),
        CategoryDataModel("Furniture", R.drawable.chair_24px, R.color.lightpurple, R.color.purple)
    )
    val images = listOf(
        R.drawable.banner2,
        R.drawable.banner3,
        R.drawable.banner4
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tại đây mới truy cập được View để setup RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recv_categories)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 5)
        recyclerView.adapter = CategoryAdapter(categories)
        viewPager2 = view.findViewById(R.id.banner_vp2)
        tabLayout = view.findViewById<TabLayout>(R.id.dotIndicator_tabL)
        val adapter = BannerAdapter(images)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { _, _ ->
            // Không làm gì ở đây
        }.attach()
        //setup

        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable{
            override fun run() {
                val nextItem = (viewPager2.currentItem + 1) % images.size
                viewPager2.setCurrentItem(nextItem, true)
                handler.postDelayed(this, slideDelay)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, slideDelay)

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)

    }
}