/* B50_2974364Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util._


class B50_2974364Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					<html><![CDATA[
					<ul>
					 <li>Click siwtchStyle then the text shall become green and bold</li>
					 <li>Click again and the text shall become black and normal</li>
					</ul>
					]]></html>
					<bandbox id="bb" value="something">
					<bandpopup>
					<listbox width="100px">
					<listitem label="A" />
					<listitem label="B" />
					<listitem label="C" />
					</listbox>
					</bandpopup>
					</bandbox>
					<button id="btn" label="switchStyle" onClick="switchStyle()" />
					<zscript>
					void switchStyle() {
					Object tag = btn.getAttribute("tag");
					if (tag == null) {
					btn.setAttribute("tag", "1");
					bb.setStyle("color:green;font-weight:bold");
					} else {
					btn.removeAttribute("tag");
					bb.setStyle("");
					}
					}
					</zscript>
				</zk>
			"""
    val ztl$engine = engine()
    val bb = ztl$engine.$f("bb")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      var bandinp = bb.$n("real")
      var origColor = jq(bandinp).css("color")
      click(btn)
      waitResponse()
      verifyEqualColor("green", jq(bandinp).css("color"))
      verifyContains("700bold", jq(bandinp).css("font-weight"))
      click(btn)
      waitResponse()
      verifyEquals(origColor, jq(bandinp).css("color"))
      verifyContains("400normal", jq(bandinp).css("font-weight"))
    })
  }
}



