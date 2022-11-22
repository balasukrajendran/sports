package pages

import geb.Page
import geb.navigator.Navigator

class SportsbetHomePage extends Page {
    static at = { sportsBetLogo.displayed }

    static content = {

        sportsBetLogo (wait:true) { $("div[data-automation-id='sportsbet-logo']")}
        firstRace (wait:true) { $("span[data-automation-id='list-1-cell-1-event-title']",0)}
        racecardButton1 (wait:true) { $("div[class='outcomeDetails_fgw55bl']",0).find("span[data-automation-id='price-text']",0) }
        raceHorseName1 (wait:true) { $("div[data-automation-id='racecard-outcome-name']",0).text() }
        racecardButton2 (wait:true)  { $("div[class='outcomeDetails_fgw55bl']",1).find("span[data-automation-id='price-text']",0) }
        raceHorseName2 (wait:true) { $("div[data-automation-id='racecard-outcome-name']",1).text() }
        betSlipCount (wait:true) { $("span[data-automation-id='header-bet-count']").text()}
        betSlipHorseName1 (wait:true) { $("span[data-automation-id='betslip-bet-title']",0).text()}
        betSlipHorseName2 (wait:true) { $("span[data-automation-id='betslip-bet-title']",1).text()}
        supportMenu { $(id:'menu-item-3367') }

    }

    def navigateToMenu(Navigator menu) {
        waitFor(30) { menu.displayed }
        interact {
            moveToElement(menu)
        }
        true
    }

    def navigateToSubmenu(Navigator submenu) {
        waitFor(30) { submenu.displayed }
        submenu.click()
        true
    }

}
