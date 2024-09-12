package org.example.expert.domain;

import org.example.expert.client.WeatherClient;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.repository.TodoRepository;
import org.example.expert.domain.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;
    @Mock
    private WeatherClient weatherClient;
    @InjectMocks
    private TodoService todoService;

    @Test
    public void 일정_조회_정상동작(){
        //given

        //when

        //then

    }
}
