package in.aman.piano2.mvpbase;

public interface IMVPPresenter<V extends IMVPView> {
  void onAttach(V view);

  void onDetach();
}
