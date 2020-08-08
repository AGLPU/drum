package in.aman.piano2.mvpbase;

import android.content.Context;
import dagger.android.support.AndroidSupportInjection;
import in.aman.piano2.theme.ThemedFragment;

public abstract class BaseFragment extends ThemedFragment implements IMVPView {

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    AndroidSupportInjection.inject(this);
  }
}
