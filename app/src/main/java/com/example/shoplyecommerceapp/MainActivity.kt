package com.example.shoplyecommerceapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.shoplyecommerceapp.databinding.MainPageBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: MainPageBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.btnLoginEmail.setOnClickListeaner {
//            FragmentTaskSheet().show(supportFragmentManager,"loginEmailTAG")
//        }
        var toolbar = findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        var navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        var toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.drawerArrowDrawable.color = ContextCompat.getColor(this, R.color.black) // Hoặc white, red, tùy bạn
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ShopByCategoriesFragment()).commit()
                // Xử lý khi nhấn "Home"
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_myorders -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MyOrderFragment()).commit()
                Toast.makeText(this, "my order clicked", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_favourites -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FavoritesFragment()).commit()
            }

            R.id.nav_address -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AddressesFragment()).commit()
            }

            R.id.nav_privacy_policy -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, PrivacyFragment()).commit()
            }
            R.id.nav_terms_and_conditions ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, tandcFragment()).commit()

            }
            R.id.nav_faqs ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FaqsFragment()).commit()

            }
            R.id.nav_logout ->{
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_saved_cards ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SavedCardsFragment()).commit()

            }
            R.id.nav_shop_by_categories ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ShopByCategoriesFragment()).commit()
            }
            // Thêm các mục khác nếu có
        }

        // Đóng Navigation Drawer sau khi chọn
        drawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
