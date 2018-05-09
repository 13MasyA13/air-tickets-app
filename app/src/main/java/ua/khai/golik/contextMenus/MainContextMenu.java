package ua.khai.golik.contextMenus;

import android.view.ContextMenu;
import android.view.View;

public class MainContextMenu implements View.OnCreateContextMenuListener {

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 1, 0, "copy");
        menu.add(0,0,0,"paste");
    }
}
