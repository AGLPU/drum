package in.aman.piano.mvpbase;

public interface IMVPPresenter<V extends IMVPView> {
  void onAttach(V view);

  void onDetach();
}
