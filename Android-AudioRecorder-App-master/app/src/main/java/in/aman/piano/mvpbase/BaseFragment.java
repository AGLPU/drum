package in.aman.piano.mvpbase;

import android.content.Context;
import dagger.android.support.AndroidSupportInjection;
import in.aman.piano.theme.ThemedFragment;

public abstract class BaseFragment extends ThemedFragment implements IMVPView {

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    AndroidSupportInjection.inject(this);
  }
}
