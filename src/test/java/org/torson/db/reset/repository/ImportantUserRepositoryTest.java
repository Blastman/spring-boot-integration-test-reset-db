package org.torson.db.reset.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.torson.db.reset.TestDbService;
import org.torson.db.reset.entities.ImportantUser;

import java.util.List;

/**
 * This test class would be much better served as a {@link DataJpaTest}. This is a {@link
 * SpringBootTest} only to show a simple test of using the {@link TestDbService}.
 */
@SpringBootTest
class ImportantUserRepositoryTest {

    @Autowired
    private ImportantUserRepository importantUserRepository;

    @Autowired
    private TestDbService testDbService;

    private ImportantUser user1;
    private ImportantUser user10;
    private ImportantUser user20;

    @BeforeEach
    void beforeEach() {
        user1 = ImportantUser.builder()
            .firstName("first10")
            .lastName("last")
            .build();

        user10 = ImportantUser.builder()
            .firstName("first")
            .lastName("last10")
            .build();

        user20 = ImportantUser.builder()
            .firstName("first20")
            .lastName("last20")
            .build();

        user1 = importantUserRepository.save(user1);
        user10 = importantUserRepository.save(user10);
        user20 = importantUserRepository.save(user20);
    }

    @AfterEach
    void afterEach() {
        testDbService.resetDatabase();
    }

    @Test
    void findByFistNameLikeOrLastNameLike() {
        List<ImportantUser> foundUsers = importantUserRepository.findByFistNameLikeOrLastNameLike("10");

        assertThat(foundUsers, hasSize(2));
        assertThat(foundUsers.get(0).getId(), is(user1.getId()));
        assertThat(foundUsers.get(1).getId(), is(user10.getId()));
    }

    @Test
    void findByFistNameLikeOrLastNameLike2() {
        List<ImportantUser> foundUsers = importantUserRepository.findByFistNameLikeOrLastNameLike("10");

        assertThat(foundUsers, hasSize(2));
        assertThat(foundUsers.get(0).getId(), is(user1.getId()));
        assertThat(foundUsers.get(1).getId(), is(user10.getId()));
    }
}