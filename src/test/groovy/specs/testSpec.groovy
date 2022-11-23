package specs

import geb.spock.GebReportingSpec
import pages.SportsbetHomePage

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.is
import static org.junit.Assert.assertThat

class testSpec extends GebReportingSpec {

    def 'Open Sportsbet page' () {

        when: 'User opens Sportsbet webpage with browser size 420 x 842'
        SportsbetHomePage sportsbetHomePage = to SportsbetHomePage

        then:'Wait for Sportsbet page is loaded completely'
          waitFor { sportsbetHomePage.sportsBetLogo.displayed }

        when: 'user clicks on Next to jump -> first card '
        waitFor {sportsbetHomePage.firstRace.isDisplayed()}
        sportsbetHomePage.firstRace.click()

        then: 'user makes the first bet'
        waitFor { sportsbetHomePage.racecardButton1.displayed }
        sportsbetHomePage.racecardButton1.click()


        waitFor {sportsbetHomePage.betSlipHideButton.displayed }
        if (sportsbetHomePage.betSlipHideButton.isDisplayed()) {
            sportsbetHomePage.betSlipHideButton.click()
        }

        when: 'user makes the second bet'
        waitFor { sportsbetHomePage.racecardButton2.displayed }
        sportsbetHomePage.racecardButton2.click()

        then: 'make sure the bets made are correct'

            waitFor { sportsbetHomePage.betSlipButton.displayed }
            sportsbetHomePage.betSlipButton.click()

            assertThat(sportsbetHomePage.betName1, is(equalTo(sportsbetHomePage.betSlipBetName1)))
            assertThat(sportsbetHomePage.betName2, is(equalTo(sportsbetHomePage.betSlipBetName2)))

    }

}
