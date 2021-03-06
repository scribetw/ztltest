/* B85_ZK_3641Test.java

        Purpose:

        Description:

        History:
                Thu Mar 29 14:34:38 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers
import org.zkoss.ztl.unit.JQuery

@IgnoreBrowsers("ios") // in iOS the autohide is broken, but it's okay since it won't block popups
class B85_ZK_3641Test extends ZTL4ScalaTestCase {


  @Test
  def test()=  {
    runZTL(() => {
      testIframeVisible(jq(".z-datebox-button"))
      testIframeVisible(jq(".z-chosenbox"))
      testIframeVisible(jq(".z-colorbox"))
    })
  }

  def testIframeVisible(wgt: JQuery)=  {
    click(wgt)
    waitResponse(true)

    verifyEquals(jq(".z-iframe").css("visibility"), "hidden")

    click(jq(".z-label"))
    waitResponse(true)
  }
}
