package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;



import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenDataRepository;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GardenDataRepositoryTest {

    @Autowired
    private GardenDataRepository underTest;

    @AfterEach
    void clearDbAfter(){
        underTest.deleteAll();
    }

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

        Optional<GardenSensorData> optionalData = underTest.selectGardenByTimestamp(timestamp);
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
        Optional<GardenSensorData> optionalGarden1 = underTest.selectGardenByTimestamp(timestamp);
        Optional<GardenSensorData> optionalGarden2 = underTest.selectGardenByTimestamp(timestamp2);

        assertThat(optionalGarden1)
                .isPresent();
        assertThat(optionalGarden2)
                 .isPresent()
                 .hasValueSatisfying(d ->{
                    assertThat(optionalGarden1.get().getGardenId()).isEqualTo(d.getGardenId());
                    assertThat(optionalGarden1.get()).isNotEqualTo(d);
                 });


    }

    @Test
    void itShouldSelectTheMostRecentTimeStampPerGardenId(){
        //Given
        UUID gardenId = UUID.randomUUID();
        Timestamp data_timestamp = Timestamp.valueOf("2012-5-21 15:25:44");
        Timestamp data_timestamp1 = Timestamp.valueOf("2012-5-22 15:25:44");
        GardenSensorData data = new GardenSensorData(gardenId, data_timestamp, true, 22.1, 12.2,55,12);
        GardenSensorData data1 = new GardenSensorData(gardenId, data_timestamp1, true, 22.1, 12.2,55,12);

        //When
        underTest.save(data);
        underTest.save(data1);

        Optional<Timestamp> optional = underTest.findLatestTimestampByGardenId(gardenId);

        assertThat(optional).isPresent()
                .hasValueSatisfying(c -> {
                    c.equals(data_timestamp1);
                });


    }

    @Test
    void itShouldSelectByMostRecentTimeStampAndGardenId() {
        UUID gardenId = UUID.randomUUID();
        Timestamp data_timestamp = Timestamp.valueOf("2012-5-21 15:25:44");
        Timestamp data_timestamp1 = Timestamp.valueOf("2012-5-22 15:25:44");
        GardenSensorData data = new GardenSensorData(gardenId, data_timestamp, true, 22.1, 12.2, 55, 12);
        GardenSensorData data1 = new GardenSensorData(gardenId, data_timestamp1, true, 22.1, 12.2, 55, 12);

        //When
        underTest.save(data);
        underTest.save(data1);

        Optional<GardenSensorData> optionalData = underTest.findLatestByGardenId(gardenId);
        assertThat(optionalData).isPresent()
                .hasValueSatisfying(c -> {
                    c.equals(data1);
                });


    }

    @Test
    void itShouldSelectMultipleEntriesForGivenTimeFrameAndId(){
        UUID gardenId = UUID.randomUUID();
        Timestamp start = Timestamp.valueOf("2012-1-21 15:25:44");
        Timestamp end = Timestamp.valueOf("2012-5-22 15:25:44");
        Timestamp time1 = Timestamp.valueOf("2012-2-22 15:25:44");
        Timestamp time2 = Timestamp.valueOf("2012-3-22 15:25:44");
        Timestamp time3 = Timestamp.valueOf("2012-4-22 15:25:44");
        List<GardenSensorData> list = new ArrayList<>();
        GardenSensorData g1 = new GardenSensorData(gardenId, time1,true, 22.1, 12.2,55,12 );
        GardenSensorData g2 = new GardenSensorData(gardenId, time2,true, 22.1, 12.2,55,12 );
        GardenSensorData g3 = new GardenSensorData(gardenId, time3, true, 22.1, 12.2,55,12 );


        underTest.save(g1);
        underTest.save(g2);
        underTest.save(g3);


        List<GardenSensorData> ret = underTest.findAllDataInRangeById(gardenId, start, end);

        assert(!ret.isEmpty());



    }



}