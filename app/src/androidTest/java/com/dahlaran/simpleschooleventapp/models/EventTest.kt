package com.dahlaran.simpleschooleventapp.models

import com.dahlaran.simpleschooleventapp.utils.DateUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class EventTest {

    lateinit var event: Event

    @Before
    fun before() {
        event = Event(
            Address("Nantes", "FR", "FRANCE", "8, rue Bréa", "44100"),
            mutableListOf(Category("56601413a3e361443919aedb", "category")),
            "Journée Portes Ouvertes ISEG Marketing &amp; Communication School Nantes<br><p>Les Journées Portes Ouvertes de l'ISEG Marketing &amp; Communication School Nantes se déroulent chaque année entre les mois de novembre et mai. Elles sont ouvertes à toute personne curieuse de découvrir ou redécouvrir l'école.<br></p>",
            "2015-09-29T09:37:47.106Z",
            "2015-12-30T12:00:00.000Z",
            "2015-12-30T08:00:00.000Z",
            mutableListOf(
                Media(
                    "561fb77d823db4ce024b6abe",
                    "media",
                    "https://res.cloudinary.com/nomadeducation/image/upload/v1453904015/vs9w6fry81f2rvozxrtd.jpg"
                )
            ),
            "Journée porte ouverte ISEG Marketing 2"
        )
    }

    @Test
    fun generateDateTest() {
        event.generateDate()
        Assert.assertEquals(DateUtils.getEventDateTime(event.dateStart)!!.time, event.eventDateStart!!.time)
    }

    @Test
    fun getEventMonthText() {
        Assert.assertEquals(12, event.getEventMonth())
    }

    @Test
    fun getEventYearText() {
        Assert.assertEquals(2015, event.getEventYear())
    }

    @Test
    fun generateEventDateTextTest() {
        Assert.assertEquals("30/12", event.generateEventDateText())
    }

    @Test
    fun generateTextContentTest() {
        val content = "Journée Portes Ouvertes ISEG Marketing & Communication School Nantes\n" +
                "\n" +
                "Les Journées Portes Ouvertes de l'ISEG Marketing & Communication School Nantes se déroulent chaque année entre les mois de novembre et mai. Elles sont ouvertes à toute personne curieuse de découvrir ou redécouvrir l'école."
        Assert.assertEquals(content, event.generateTextContent())
    }
}