package com.smrtgrdyn.smrtgrdyn.Garden.Image;

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
class GardenImageRepositoryTest {

    @Autowired
    GardenImageRepository underTest;

    @Test
    void databaseShouldNotBeNull(){
        assertThat(underTest).isNotNull();
    }

    @Test
    void databaseShouldSaveImage(){
        //Given
        UUID gardenId = UUID.randomUUID();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GardenImage data = new GardenImage(gardenId, timestamp, "1231321321");
        GardenImageId id = new GardenImageId(gardenId, timestamp);
        //When
        underTest.save(data);
        Optional<GardenImage> gardenImageOptional = underTest.findById(id);

        //Then
        assertThat(gardenImageOptional)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).isEqualTo(data);
                });



    }

}