package com.android.myapplication.flashnews.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.android.myapplication.flashnews.R
import com.android.myapplication.flashnews.ui.sources.ArticlesSourceFragment
import com.android.myapplication.flashnews.util.BottomNavController
import com.android.myapplication.flashnews.util.load
import com.android.myapplication.flashnews.util.setUpNavigation
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),
    BottomNavController.NavGraphProvider,
    BottomNavController.OnNavigationGraphChanged,
    BottomNavController.OnNavigationReselectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private val bottomNavController by lazy(LazyThreadSafetyMode.NONE) {
        BottomNavController(
            context=this,
            containerId = R.id.main_nav_host_fragment,
            appStartDestinationId = R.id.nav_headlines,
            graphChangeListener = this,
            navGraphProvider = this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBar()
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setUpNavigation(bottomNavController,this)
        if(savedInstanceState == null){
            bottomNavController.onNavigationItemSelected()
        }
    }

    override fun getNavGraphId(itemId: Int): Int = when (itemId) {
        R.id.nav_sources -> {
            R.navigation.nav_sources
        }
        R.id.nav_favorites -> {
            R.navigation.nav_favorites
        }
        else -> {
            R.navigation.nav_headlines
        }
    }

    private fun setupActionBar() = setSupportActionBar(toolbar)


    override fun displayProgressBar(bool: Boolean) = progress_bar.load(bool)

    override fun onBackPressed() = bottomNavController.onBackPressed()

    override fun onOptionsItemSelected(item: MenuItem) =
        when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else->super.onOptionsItemSelected(item)
        }



    override fun onGraphChange() {
        cancelActiveJobs()
        expandAppBar()
    }


    //cancel ActivityJobs should Be cancelled when we change the navGraph or
    // when we change a fragment within the same graph(this is handled in onViewCreated of each fragment)
    private fun cancelActiveJobs(){
        val fragments = bottomNavController.fragmentManager
            .findFragmentById(bottomNavController.containerId)
            ?.childFragmentManager
            ?.fragments
        fragments?.let {
            for(fragment in it){
                if(fragment is BaseFragment){
                    fragment.cancelActiveJobs()
                }
            }
        }
        //displayProgressBar(false)
    }

    override fun onReselectNavItem(navController: NavController, fragment: Fragment) {
        if(fragment is ArticlesSourceFragment){
            navController.navigate(R.id.action_articlesSourceFragment_to_sourcesFragment)
        }
    }




    override fun expandAppBar() = findViewById<AppBarLayout>(R.id.appbar_layout).setExpanded(true)

}