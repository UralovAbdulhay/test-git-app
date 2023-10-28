package com.example.repository;

import com.example.entity.Count;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CounterRepositoryTest {
    @Autowired
    private CounterRepository counterRepository;

    @Test
    void findBySession() {
        Count count=new Count("js14789");
        counterRepository.save(count);
        Optional<Count> js = counterRepository.findBySession("js14789");
        assertThat(js.get()).isEqualTo(new Count("js14789"));

    }
    @AfterEach
    void del(){
        counterRepository.deleteAll();
    }
}