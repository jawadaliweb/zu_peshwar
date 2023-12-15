package com.lmkt.zupeshawar.db;

import java.util.List;

public interface BicycleStationDao {
    void deleteStation(BicyclesTB bicyclesTB);

    List<BicyclesTB> getStations();

    void insertStation(BicyclesTB bicyclesTB);

    void updateStation(BicyclesTB bicyclesTB);
}
