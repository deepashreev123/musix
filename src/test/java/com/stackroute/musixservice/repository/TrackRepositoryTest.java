package com.stackroute.musixservice.repository;


import com.stackroute.musixservice.domain.Track;
import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {


    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackID(1);
        track.setTrackName("John");
        track.setTrackComments("gewr");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackID()).get();
        Assert.assertEquals(10,fetchTrack.getTrackID());

   }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new  Track(1,"john","gewr");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackID()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAlltrack() {
        Track track = new Track(2, "fdfdrt", "gvfdsdhdh");
        Track track1 = new Track(1, "fdfd", "gsaggfs");
        trackRepository.save(track);
        trackRepository.save(track1);

        List<Track> list = (List<Track>) trackRepository.findAll();
        Assert.assertEquals("fdfd", list.get(0).getTrackName());
    }
    @Test
    public void testUpdateTrackFailure(){
        Track testTrack = new  Track(1,"john","gewr");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackID()).get();
        Assert.assertNotSame(testTrack,track);

    }

}