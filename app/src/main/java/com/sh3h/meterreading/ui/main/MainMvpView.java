package com.sh3h.meterreading.ui.main;

import com.sh3h.datautil.data.model.Ribot;
import com.sh3h.meterreading.ui.base.MvpView;

import java.util.List;

public interface MainMvpView extends MvpView {

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}
