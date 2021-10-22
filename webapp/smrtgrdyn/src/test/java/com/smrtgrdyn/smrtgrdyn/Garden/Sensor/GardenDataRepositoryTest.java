package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GardenDataRepositoryTest {

    @Autowired
    private GardenDataRepository underTest;

    @Test
    void databaseShouldNotBeNull(){
        assertThat(underTest).isNotNull();
    }

    @Test
    void itShouldSaveGarden(){
        //Given
        UUID gardenId = UUID.randomUUID();
        String timestamp = "123456";
        GardenSensorData data = new GardenSensorData(gardenId, timestamp, false, 0, 0,0,0);
        //When
        underTest.save(data);
        Optional<GardenSensorData> gardenSensorDataOptional = underTest.findById(gardenId);

        //Then
        assertThat(gardenSensorDataOptional)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).isEqualTo(data);
                });
    }

    @Test
    void itShouldSelectGardenByTimestamp(){
        UUID gardenId = UUID.randomUUID();
        String timestamp = "123456";
        GardenSensorData data = new GardenSensorData(gardenId, timestamp, false, 0, 0,0,0);

        underTest.save(data);

        Optional<GardenSensorData> optionalData = underTest.selectCustomerByTimestamp(timestamp);
        assertThat(optionalData)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).isEqualTo(data);
                });
    }
    @Test
    void itShouldSaveTwoEntriesFromSaveGarden(){
        //Given
        UUID gardenId = UUID.randomUUID();
        String timestamp = "123456";
        GardenSensorData data = new GardenSensorData(gardenId, timestamp, false, 0, 0,0,0);

        String timestamp2 = "123654";
        GardenSensorData data2 = new GardenSensorData(gardenId, timestamp2, false, 0, 0,0,0);
        //When

        underTest.save(data);
        underTest.save(data2);

        //Then
        Optional<GardenSensorData> optionalGarden1 = underTest.selectCustomerByTimestamp(timestamp);
        Optional<GardenSensorData> optionalGarden2 = underTest.selectCustomerByTimestamp(timestamp2);

        assertThat(optionalGarden1)
                .isPresent();
        assertThat(optionalGarden2)
                 .isPresent()
                 .hasValueSatisfying(d ->{
                    assertThat(optionalGarden1.get().getGardenId()).isEqualTo(d.getGardenId());
                    assertThat(optionalGarden1.get()).isNotEqualTo(d);
                 });
    }

}