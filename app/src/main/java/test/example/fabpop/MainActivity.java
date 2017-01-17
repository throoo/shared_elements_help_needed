package test.example.fabpop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This project is an attempt to use shared elements between MainActivity and SheetDialog
 *
 * There are two FABs in the project - Feather and Plane
 *
 * When Feather is clicked, the SheetDialog is opened, and Feather should animate over to Plane
 * dialog because it is a shared element
 *
 * Why does this not work?
 */
public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_feather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_feather = (FloatingActionButton) findViewById(R.id.initial_fab_feather);
    }

    public void fabClick(View view) {
        SheetDialog dialogFragment = new SheetDialog();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // This seemingly has no effect. I am trying to get it to work.
        transaction.addSharedElement(fab_feather, "transition_name_plane");

        dialogFragment.setSharedElementEnterTransition(new ChangeBounds());
        dialogFragment.setSharedElementReturnTransition(new Fade(Fade.OUT));

        dialogFragment.show(transaction, "frag_tag");
    }
}
