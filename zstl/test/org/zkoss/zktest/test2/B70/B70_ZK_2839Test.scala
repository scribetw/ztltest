package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2839.zul")
class B70_ZK_2839Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      //click the global button twice
      click(jq("button").eq(0))
      waitResponse()
      click(jq("button").eq(0))
      waitResponse()
      //click the local button once
      click(jq("button").eq(1))
      waitResponse(true)
      //check for 3 messages in zk.log
      verifyEquals("hello from global f1()\nhello from global f1()\nhello from local f2()\n", getZKLog())
    })
  }
}