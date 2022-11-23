package pages
import geb.Page
import static org.hamcrest.Matchers.is
import static org.junit.Assert.assertThat

class SportsbetHomePage extends Page {
    static at = { sportsBetLogo.displayed }

    static content = {

        sportsBetLogo (wait:true) { $("div[data-automation-id='sportsbet-logo']")}
        firstRace (wait:true) { $("div[data-automation-id='group-1-carousel-1-body-container-cell-1']",0)}
        racecardButton1 (wait:true) { $("div[data-automation-id='racecard-price-button-deselected']",0) }
        betName1 (wait:true) { $("div[data-automation-id='racecard-outcome-name']",0).text() }
        racecardButton2 (wait:true)  { $("div[data-automation-id='racecard-price-button-deselected']",1) }
        betName2 (wait:true) { $("div[data-automation-id='racecard-outcome-name']",1).text() }
        betSlipHideButton {$("[data-automation-id='betslip-header-hide']")}
        betSlipButton { $("button[data-automation-id='header-betslip-touchable']")}
        betSlipCount (wait:true) { $("span[data-automation-id='header-bet-count']").text()}
        betSlipBetName1 (wait:true) { $("span[data-automation-id='betslip-bet-title']",0).text()}
        betSlipBetName2 (wait:true) { $("span[data-automation-id='betslip-bet-title']",1).text()}
        supportMenu { $(id:'menu-item-3367') }
    }

    public void verifyBets() {
        assertThat(betName1,is(betSlipBetName1))
        assertThat(betName2,is(betSlipBetName2))
    }

}
