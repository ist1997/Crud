package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballerTest {

    private Footballer footballer;

    @Before
    public void setUp() throws Exception {
        footballer = new Footballer(1, "Mane", "Liverpool", "Senegal", 75);
    }

    @Test
    public void getIdTest() {
        Assert.assertEquals(1, footballer.getId());
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Mane", footballer.getName());
    }

    @Test
    public void getTeamTest() {
        Assert.assertEquals("Liverpool", footballer.getTeam());
    }

    @Test
    public void getNationalityTest() {
        Assert.assertEquals("Senegal", footballer.getNationality());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(75, footballer.getPrice(), 0.00001);
    }
}