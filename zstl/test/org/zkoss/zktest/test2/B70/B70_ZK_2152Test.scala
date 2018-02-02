package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2152.zul")
class B70_ZK_2152Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      click(jq(".z-datebox-button").eq(0))
      waitResponse()
      var inp = jq(".z-timebox-input").eq(0)
      zk(inp).eval("setSelectionRange(0);'test'")
      sendKeys(inp, Keys.HOME)
      waitResponse()
      keyPress(inp, "210000")
      waitResponse()
      sendKeys(inp, Keys.ENTER)
      waitResponse()
      verifyEquals(jq("@datebox").eq(0).toWidget().get("text"), "10/10/2014 21:00:00");
      
      click(jq(".z-datebox-button").eq(1))
      waitResponse()
      inp = jq(".z-timebox-input").eq(1)
      zk(inp).eval("setSelectionRange(0);'test'")
      sendKeys(inp, Keys.HOME)
      waitResponse()
      keyPress(inp, "110000")
      waitResponse()
      sendKeys(inp, Keys.ENTER)
      waitResponse()
      verifyEquals(jq("@datebox").eq(1).toWidget().get("text"), "10/10/2014 11:00:00 AM")
      
      click(jq(".z-datebox-button").eq(2))
      waitResponse()
      inp = jq(".z-timebox-input").eq(2)
      zk(inp).eval("setSelectionRange(0);'test'")
      sendKeys(inp, Keys.HOME)
      waitResponse()
      keyPress(inp, "110000")
      waitResponse()
      sendKeys(inp, Keys.ARROW_RIGHT)
      waitResponse()
      sendKeys(inp, Keys.ARROW_UP)
      waitResponse()
      sendKeys(inp, Keys.ENTER)
      waitResponse()
      verifyEquals(jq("@datebox").eq(2).toWidget().get("text"), "10/10/2014 11:00:00 AM")

      click(jq(".z-datebox-button").eq(3))
      waitResponse()
      inp = jq(".z-timebox-input").eq(3)
      zk(inp).eval("setSelectionRange(0);'test'")
      sendKeys(inp, Keys.HOME)
      waitResponse()
      keyPress(inp, "210000");
      waitResponse()
      sendKeys(inp, Keys.ENTER)
      waitResponse()
      verifyEquals(jq("@datebox").eq(3).toWidget().get("text"), "10/10/2014 21:00:00")
    })
    
  }
}
