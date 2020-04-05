package adhilrahiman.sharedelementtransition.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import adhilrahiman.sharedelementtransition.fragment.ImageFragment;

import static adhilrahiman.sharedelementtransition.adapter.ImageData.IMAGE_DRAWABLES;

public class ImagePagerAdapter extends FragmentStatePagerAdapter {

  public ImagePagerAdapter(Fragment fragment) {
    // Note: Initialize with the child fragment manager.
    super(fragment.getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
  }

  @Override
  public int getCount() {
    return IMAGE_DRAWABLES.length;
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return ImageFragment.newInstance(IMAGE_DRAWABLES[position]);
  }
}
