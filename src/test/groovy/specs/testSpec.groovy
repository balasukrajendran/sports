package specs

import geb.spock.GebReportingSpec
import pages.SportsbetHomePage

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.is
import static org.junit.Assert.assertThat

class testSpec extends GebReportingSpec {

    def 'Open Sportsbet page' () {
        when: 'User opens Sportsbet webpage'
        SportsbetHomePage sportsbetHomePage = to SportsbetHomePage

        then:'verify if Sportsbet page is loaded completely'
          waitFor { sportsbetHomePage.sportsBetLogo.displayed }

        when: 'user clicks on Next to jump -> first card '
        sportsbetHomePage.firstRace.click()

        then: 'click on the market button for the first horse'
        waitFor { sportsbetHomePage.racecardButton1.displayed }
        sportsbetHomePage.racecardButton1.click()

        and: 'click on the market button for the second horse'
        waitFor { sportsbetHomePage.racecardButton2.displayed }
        sportsbetHomePage.racecardButton2.click()

        assertThat(sportsbetHomePage.raceHorseName1,is(equalTo(sportsbetHomePage.betSlipHorseName1)))
        assertThat(sportsbetHomePage.raceHorseName2,is(equalTo(sportsbetHomePage.betSlipHorseName2)))
    }

}
