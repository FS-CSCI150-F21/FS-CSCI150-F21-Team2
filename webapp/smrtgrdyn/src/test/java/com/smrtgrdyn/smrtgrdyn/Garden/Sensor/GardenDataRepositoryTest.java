package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GardenSensorData data = new GardenSensorData(gardenId, timestamp, false, 0, 0,0,0);
        GardenSensorDataId id = new GardenSensorDataId(gardenId, timestamp);
        //When
        underTest.save(data);
        Optional<GardenSensorData> gardenSensorDataOptional = underTest.findById(id);

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
        Timestamp timestamp = Timestamp.valueOf("2012-5-21 15:25:44");
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
    void itShouldSaveTwoEntriesFromTheSameGarden(){
        //Given
        UUID gardenId = UUID.randomUUID();
        Timestamp timestamp = Timestamp.valueOf("2012-5-21 15:25:44");
        GardenSensorData data = new GardenSensorData(gardenId, timestamp, false, 0, 0,0,0);

        Timestamp timestamp2 = Timestamp.valueOf("2012-6-21 15:25:44");

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