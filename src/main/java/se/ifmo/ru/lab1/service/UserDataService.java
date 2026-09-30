package se.ifmo.ru.lab1.service;

import se.ifmo.ru.lab1.dto.DataRequest;
import se.ifmo.ru.lab1.dto.DataResponse;
import se.ifmo.ru.lab1.model.UserData;

import java.util.List;

public interface UserDataService {
    List<DataResponse> getAllData();
    UserData createData(DataRequest request);
}
