/* B50_2988261Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2988261Test extends ZTL4ScalaTestCase {
  @Test
  def testPopup() = {
    var zscript =
      """
		<zk>
		<portallayout width="100%" height="100%" maximizedMode="whole">
		<portalchildren width="50%" height="100%">
		<panel id="panel" border="normal" title="test" height="400px" maximizable="true">
		<toolbar>
		<combobox id="cb"/>
		</toolbar>
		<panelchildren>
		<window width="100%" height="100%" />
		</panelchildren>
		</panel>
		</portalchildren>
		</portallayout>
		</zk>
		"""
    val ztl$engine = engine()
    val panel = ztl$engine.$f("panel")
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(panel.$n("max"))
      click(cb.$n("btn"));
      verifyTrue(parseInt(jq(cb.$n("pp")).css("zIndex")) > parseInt(jq(panel).css("zIndex")))
    })
  }
}



