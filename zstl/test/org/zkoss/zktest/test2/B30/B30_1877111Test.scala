/* B30_1877111Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1877111Test extends ZTL4ScalaTestCase {
  @Test
  def testLenient() = {
    var zscript =
      """
			<zk>
				<html>
					<![CDATA[ <ol> <li>Type 12-13-98 in the first datebox</li>
					<li>Type TAB to move focus away</li> </ol> Then, an error
					message shall show up. However, no error message in the second
					one. ]]>
				</html>
				<hbox>
					lenient=false, MM.dd.yy:
					<datebox id="d" format="MM.dd.yy" lenient="false" />
				</hbox>
				<hbox>
					lenient=true, MM.dd.yy:
					<datebox id="d2" format="MM.dd.yy" lenient="true" />
				</hbox>
				<hbox>
					lenient=false, MMM d, yyyy:
					<datebox id="d3" format="MMM d, yyyy" lenient="false" />
				</hbox>
				<zscript>
				    d.focus();
				</zscript>
			</zk>
		"""
    val ztl$engine = engine()
    val d = ztl$engine.$f("d")
    val d2 = ztl$engine.$f("d2")
    val d3 = ztl$engine.$f("d3")
    runZTL(zscript, () => {
      var inp = jq(".z-datebox:eq(0)").toWidget().$n("real")
      sendKeys(inp, "12-13-98" + Keys.TAB)
      waitResponse(true)
      verifyTrue(jq(".z-errorbox").exists())
      click(jq(".z-errorbox").toWidget().$n("cls"))
      waitResponse()
      var inp1 = jq(".z-datebox:eq(1)").toWidget().$n("real")
      sendKeys(inp1, "12-13-98" + Keys.TAB)
      var inp2 = jq(".z-datebox:eq(2)").toWidget().$n("real")
      sendKeys(inp2, "12-13-98" + Keys.TAB)
      waitResponse(true)
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



