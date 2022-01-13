package examenes.extra2.test;

import examenes.extra2.source.socialNetwork.SocialNetwork;
import org.junit.Assert;

public class SocialNetworkTest {

    private SocialNetwork socialNetwork;

    @org.junit.Before
    public void setUp() throws Exception {
        socialNetwork = new SocialNetwork();
        socialNetwork.addUser("Spiderman");
        socialNetwork.addUser("Captain America");
        socialNetwork.addUser("Iron Man");
        socialNetwork.addUser("Hulk");
        socialNetwork.addUser("Thor");
        socialNetwork.addUser("Gamora");
        socialNetwork.addUser("Drax");
        socialNetwork.addUser("Starlord");
        socialNetwork.addUser("Groot");
        socialNetwork.addUser("Rocket");
        socialNetwork.makeFriends("Spiderman", "Captain America");
        socialNetwork.makeFriends("Spiderman", "Iron Man");
        socialNetwork.makeFriends("Spiderman", "Hulk");
        socialNetwork.makeFriends("Captain America", "Iron Man");
        socialNetwork.makeFriends("Captain America", "Hulk");
        socialNetwork.makeFriends("Captain America", "Thor");
        socialNetwork.makeFriends("Iron Man", "Hulk");
        socialNetwork.makeFriends("Thor", "Starlord");
        socialNetwork.makeFriends("Gamora", "Drax");
        socialNetwork.makeFriends("Gamora", "Starlord");
        socialNetwork.makeFriends("Gamora", "Groot");
        socialNetwork.makeFriends("Gamora", "Rocket");
        socialNetwork.makeFriends("Drax", "Starlord");
        socialNetwork.makeFriends("Drax", "Groot");
        socialNetwork.makeFriends("Drax", "Rocket");
        socialNetwork.makeFriends("Starlord", "Groot");
        socialNetwork.makeFriends("Starlord", "Rocket");
        socialNetwork.makeFriends("Groot", "Rocket");
    }

    @org.junit.Test
    public void filter() throws Exception {
        String expected = "Thor";
        int results = 0;
        
        for (String user : socialNetwork.filter(3)) {
            Assert.assertEquals(expected, user);
            results++;
        }
        Assert.assertEquals(1, results);
    }

    @org.junit.Test
    public void groups() throws Exception {
        int nClusters = socialNetwork.groups();
        Assert.assertEquals(1, nClusters);
        socialNetwork.filter(3);
        nClusters = socialNetwork.groups();
        Assert.assertEquals(2, nClusters);
    }

}