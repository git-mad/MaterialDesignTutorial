package com.gitmad.tejasvinareddyteju.materialdesign.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;
import com.gitmad.tejasvinareddyteju.materialdesign.R;
import com.gitmad.tejasvinareddyteju.materialdesign.fragment.ImageGridFragment;
import com.gitmad.tejasvinareddyteju.materialdesign.fragment.TextListFabFragment;

/**
 * Main activity that contains the navigation drawer.
 *
 * @author nareddyt
 */
public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    public void onBackPressed() {
        // TODO check if the drawer is open. If it is, then close the drawer.
        // Note that the drawer is declared on line 28. Just assume that it is initialized for now
        // Otherwise, just use the default back button implementation by calling the super method
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle the navigation drawer clicks here
        int id = item.getItemId();

        Fragment fragment = null;
        // TODO instantiate the fragment object (above) based on the MenuItem that is selected
        // Essentially, we want to select a different fragment for each menu item that is clicked
        // All the code should go in the if statements
        // HINT: Polymorphism is useful
        if (id == R.id.text_grid) {
            // TODO instantiate the proper fragment, and store it in the fragment variable above
        } else if (TODO) {
            // TODO instantiate the proper fragment, and store it in the fragment variable above
        } else if (TODO) {
            // TODO instantiate the proper fragment, and store it in the fragment variable above
        }

        // Error checking
        if (fragment == null) {
            Toast.makeText(this, "No navigation drawer for these", Toast.LENGTH_SHORT).show();
            return false;
        }

        // TODO Transition to the fragment by changing the main frame layout (in the Navigation Drawer)
        // HINT: Use the FragmentManager and begin a transition to the next fragment
        // If you're really stuck, look at line 110. Try to figure out how a FragmentManager works first
        FragmentManager fragmentManager = getSupportFragmentManager();

        // TODO Close the drawer when an item is selected
        // Hint: The drawer object is declared as a global variable on line 28.

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the view
        setContentView(R.layout.activity_navigation);

        // The following code can be found in the slides under the toolbar/actionbar section
        // TODO find the toolbar/actionbar in the view
        // TODO Set up the actionbar using the support library

        // The following code can be found in the slides under the navigation drawer section
        // TODO Instantiate the drawer object from the XML. Note that this class already has a member variable on line 28
        // TODO Set up the drawer toggle and sync the state

        // Instantiate the navigation view, which shows the entire navigation drawer's view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        // TODO set the proper NavigationItemSelectedListener
        // HINT: Look at line 26... This class itself implements NavigationView.OnNavigationItemSelectedListener

        // Use the fragment manager to begin a transaction to the first fragment (by default)
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFrameLayout, TextListFabFragment.newInstance()).commit();

        // Random hack to set up the navigation/status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
