package com.example.shoplyecommerceapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.shoplyecommerceapp.R
import com.example.shoplyecommerceapp.databinding.MainPageBinding
import com.example.shoplyecommerceapp.views.AccountFragment
import com.example.shoplyecommerceapp.views.AddressesFragment
import com.example.shoplyecommerceapp.views.FaqsFragment
import com.example.shoplyecommerceapp.views.FavoritesFragment
import com.example.shoplyecommerceapp.views.HomeFragment
import com.example.shoplyecommerceapp.views.MyOrderFragment
import com.example.shoplyecommerceapp.views.PrivacyFragment
import com.example.shoplyecommerceapp.views.SavedCardsFragment
import com.example.shoplyecommerceapp.views.ShopByCategoriesFragment
import com.example.shoplyecommerceapp.views.auth.signup.SignupFragment
import com.example.shoplyecommerceapp.views.tandcFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: MainPageBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar = binding.toolBar
        setSupportActionBar(toolbar)

        drawerLayout = binding.drawerLayout

        var navigationView = binding.navView
        navigationView.setNavigationItemSelectedListener(this)

        var toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        toggle.drawerArrowDrawable.color = ContextCompat.getColor(this, R.color.black) // Hoặc white, red, tùy bạn
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        var bottomNavigationView = binding.bottomToolbar
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_orders -> {
                    replaceFragment(MyOrderFragment())
                    true
                }
                R.id.bottom_categories -> {
                    replaceFragment(ShopByCategoriesFragment())
                    true
                }
                R.id.bottom_account -> {
                    replaceFragment(AccountFragment())
                    true
                }
                 else -> false
            }
        }


        // xử lí nav header
        val headerView = binding.navView.getHeaderView(0)
        val loginButton = headerView.findViewById<Button>(R.id.login_btn)
        val signupButton = headerView.findViewById<Button>(R.id.signup_btn)

        loginButton.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            intent.putExtra("SHOW_SIGNUP", false) //show login
            startActivity(intent)
        }

        signupButton.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            intent.putExtra("SHOW_SIGNUP", true) //show login
            startActivity(intent)
        }
//        var bottomNavigationView = findViewById(R.id.bottom_toolbar)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.signup_btn -> {
                replaceFragment(SignupFragment())
            }
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
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}
