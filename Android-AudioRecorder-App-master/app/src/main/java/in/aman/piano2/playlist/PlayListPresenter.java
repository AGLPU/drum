package in.aman.piano2.playlist;

import in.aman.piano2.db.RecordingItem;
import in.aman.piano2.mvpbase.IMVPPresenter;

public interface PlayListPresenter<V extends PlayListMVPView> extends IMVPPresenter<V> {
  void onViewInitialised();

  void renameFile(int position, String value);

  void deleteFile(int position);

  RecordingItem getListItemAt(int position);

  void onListItemClick(int position);

  void onListItemLongClick(int position);

  int getListItemCount();

  void shareFileClicked(int position);

  void renameFileClicked(int position);

  void deleteFileClicked(int position);

  void mediaPlayerStopped();
}
