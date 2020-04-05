package adhilrahiman.sharedelementtransition;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import adhilrahiman.sharedelementtransition.fragment.GridFragment;


/**
 * Grid to pager app's main activity.
 */
public class MainActivity extends AppCompatActivity {

  /**
   * Holds the current image position to be shared between the grid and the pager fragments. This
   * position updated when a grid item is clicked, or when paging the pager.
   *
   * In this demo app, the position always points to an image index at the {@link
   * adhilrahiman.sharedelementtransition.adapter.ImageData} class.
   */
  public static int currentPosition;
  private static final String KEY_CURRENT_POSITION = "com.google.samples.gridtopager.key.currentPosition";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (savedInstanceState != null) {
      currentPosition = savedInstanceState.getInt(KEY_CURRENT_POSITION, 0);
      // Return here to prevent adding additional GridFragments when changing orientation.
      return;
    }
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager
        .beginTransaction()
        .add(R.id.fragment_container, new GridFragment(), GridFragment.class.getSimpleName())
        .commit();
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt(KEY_CURRENT_POSITION, currentPosition);
  }
}
