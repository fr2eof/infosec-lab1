package se.ifmo.ru.lab1.service.impl;

import lombok.AllArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import se.ifmo.ru.lab1.dto.DataRequest;
import se.ifmo.ru.lab1.dto.DataResponse;
import se.ifmo.ru.lab1.model.UserData;
import se.ifmo.ru.lab1.repository.UserDataRepository;
import se.ifmo.ru.lab1.service.UserDataService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserDataRepository dataRepository;

    public List<DataResponse> getAllData() {
        return dataRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserData createData(DataRequest request) {
        UserData data = new UserData();
        data.setTitle(request.getTitle());
        data.setContent(request.getContent());

        return dataRepository.save(data);
    }

    private DataResponse toResponse(UserData data) {
        return new DataResponse(
                data.getId(),
                StringEscapeUtils.escapeHtml4(data.getTitle()),
                StringEscapeUtils.escapeHtml4(data.getContent())
        );
    }
}
