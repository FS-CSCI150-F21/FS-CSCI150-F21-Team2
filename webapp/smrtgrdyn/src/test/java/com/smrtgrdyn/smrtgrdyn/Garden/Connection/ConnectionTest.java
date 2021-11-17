package com.smrtgrdyn.smrtgrdyn.Garden.Connection;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenImageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConnectionTest {

    @Autowired
    GardenConnectionInformationRepository underTest;


    @Test
    void itShouldFindEntryById(){
        //Given
        String gardenId = UUID.randomUUID().toString();

        GardenConnectionInformation data = new GardenConnectionInformation(gardenId, "Ryan1Up", "10.0.0.1", 80);

        //When
        underTest.save(data);
        //Then

        Optional<GardenConnectionInformation> optional = underTest.findById(gardenId);


        assertThat(optional).isPresent().hasValueSatisfying(c -> {
            c.equals(data);
        });
    }

}
