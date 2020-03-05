package com.app.maps;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.app.maps.model.Map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseRepository {

    private static final String TAG = "BaseRepository";

    public LiveData<List<Map>> getMapDB(String orderId) {
        final MutableLiveData<List<Map>> mutableLiveData = new MutableLiveData<>();
        String sql = "SELECT * FROM maps WHERE OrderID = '" + orderId + "'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            ArrayList<Map> list = new ArrayList<>();
                            while (resultSet.next()) {
                                Map map = new Map(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getDouble(3),
                                        resultSet.getDouble(4)
                                );
                                list.add(map);
                            }
                            mutableLiveData.setValue(list);

                            for (Map item : list) {
                                Log.d(TAG, "onComplete: " + item.getLatitude() + "," + item.getLongitude());
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return mutableLiveData;
    }

    public void updateLocationDB(String mapId, double lat, double lng){
        String sql = "UPDATE `maps` SET Latitude="+lat+",Longitude="+lng+" WHERE MapID = "+mapId+"";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit();
    }
}
