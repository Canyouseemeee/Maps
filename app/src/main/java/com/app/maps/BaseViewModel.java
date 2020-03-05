package com.app.maps;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.maps.model.Map;

import java.util.List;

public class BaseViewModel extends ViewModel {

    private BaseRepository repository = new BaseRepository();

    public LiveData<List<Map>> getMapDB(String orderId){
        return repository.getMapDB(orderId);
    }

    public void updateLocation(String mapId,double lat,double lng){
        repository.updateLocationDB(mapId,lat,lng);
    }

}
