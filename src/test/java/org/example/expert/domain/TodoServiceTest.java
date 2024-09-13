package org.example.expert.domain;

import org.example.expert.client.WeatherClient;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.todo.dto.request.TodoSaveRequest;
import org.example.expert.domain.todo.dto.response.TodoSaveResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.repository.TodoRepository;
import org.example.expert.domain.todo.service.TodoService;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
    TodoService todoService;

    @Mock
    WeatherClient weatherClient;

    @Mock
    TodoRepository todoRepository;

    @Test
    void saveTodo_success(){

        //비즈니스 로직 처리를 위한 Test Code

        //given ( 비즈니스 로직을 제외한 메소드나 등등 )
        AuthUser authUser = new AuthUser(1L, "email", UserRole.ADMIN);
        TodoSaveRequest todoSaveRequest = new TodoSaveRequest("title", "contents");

        given(weatherClient.getTodayWeather())
                .willReturn("sunny");

        Todo savedTodo = new Todo("title", "content","sunny", new User("email", "Test1234!", UserRole.ADMIN));
        ReflectionTestUtils.setField(savedTodo, "id", 1L);
        given(todoRepository.save(any(Todo.class)))
                .willReturn(savedTodo);

        //when
        TodoSaveResponse todoSaveResponse = todoService.saveTodo(authUser, todoSaveRequest);

        //then
        assertNotNull(todoSaveResponse);
    }
}
